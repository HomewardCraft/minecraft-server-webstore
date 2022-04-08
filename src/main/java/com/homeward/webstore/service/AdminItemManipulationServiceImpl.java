package com.homeward.webstore.service;

import com.alibaba.fastjson.JSONObject;
import com.homeward.webstore.common.enums.AdministratorStatusEnum;
import com.homeward.webstore.common.util.CommonUtils;
import com.homeward.webstore.java.bean.BO.FileImageBO;
import com.homeward.webstore.java.bean.BO.ItemName;
import com.homeward.webstore.java.bean.PO.ItemWholeInfo;
import com.homeward.webstore.mapper.AdminItemManipulationMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.*;

@Service
@PropertySource("classpath:/directories.properties")
public class AdminItemManipulationServiceImpl implements AdminItemManipulationService {
    private final AdminItemManipulationMapper adminItemManipulationMapper;

    @Value("${baseUrl}")
    private String baseUrl;
    @Value("${projectPath}")
    private String projectPath;
    @Value("${preUrl}")
    private String preUrl;
    @Value("${image.director}")
    private String imageDirector;
    @Value("${test.projectPath}")
    private String testProjectPath;

    public AdminItemManipulationServiceImpl(AdminItemManipulationMapper adminItemManipulationMapper) {
        this.adminItemManipulationMapper = adminItemManipulationMapper;
    }

    @Override
    @Transactional
    public void insertItem(ItemWholeInfo information) {
        String type = information.getType().toLowerCase();
        // verify
        Long itemAmount = adminItemManipulationMapper.isExist(type, information.getName());
        if (itemAmount != 0) {
            CommonUtils.throwRuntimeException(AdministratorStatusEnum.ITEM_NAME_DUPLICATED);
        }

        // generate description id
        information.setDescriptionId(UUID.randomUUID().toString());

        // insert description
        Boolean insertDescription = adminItemManipulationMapper.insertDescription(information);
        if (!insertDescription) CommonUtils.throwRuntimeException(AdministratorStatusEnum.BACKEND_ERROR);

        // insert basic information
        if ("extras".equals(type)) {
            if (null == information.getRawSalePercent()) {
                information.setRawSalePercent("100");
            }
            information.setSalePercent(Integer.valueOf(information.getRawSalePercent() + ""));

            Boolean insertInformation = adminItemManipulationMapper.insertItemInformation(information);
            if (!insertInformation) CommonUtils.throwRuntimeException(AdministratorStatusEnum.BACKEND_ERROR);

        } else if ("crates".equals(type)) {
            String rawName = information.getName();
            Integer rawPrice = information.getPrice();
            List<ItemWholeInfo> informationList = new ArrayList<>();

            JSONObject rawSalePercent = JSONObject.parseObject(information.getRawSalePercent());
            rawSalePercent.forEach((rawPrefix, salePercent) -> {
                Integer amount = Integer.valueOf(rawPrefix.substring(1));
                String prefix = amount + "x";
                String name = String.format("%s %s", prefix, rawName);

                information.setName(name);
                information.setPrice(rawPrice * amount);
                if (null == salePercent || "" == salePercent) {
                    information.setSalePercent(100);
                    information.setSaleCondition(false);
                } else {
                    information.setSalePercent(Integer.valueOf(salePercent + ""));
                    information.setSaleCondition(true);
                }
                informationList.add(information.clone());
            });

            informationList.sort(Comparator.comparing(ItemWholeInfo::getPrice));

            Boolean informationIsInserted = adminItemManipulationMapper.insertItemInformationList(informationList);
            if (!informationIsInserted) {
                CommonUtils.throwRuntimeException(AdministratorStatusEnum.BACKEND_ERROR);
            }
        } else {
            CommonUtils.throwRuntimeException(AdministratorStatusEnum.ITEM_TYPE_NOT_MATCH);
        }
    }

    @Override
    @Transactional
    public void updateItem(ItemWholeInfo information) {
        // get description id
        String descriptionId = adminItemManipulationMapper.selectDescriptionId(information.getId());
        information.setDescriptionId(descriptionId);

        // update description
        Boolean updateDescription = adminItemManipulationMapper.updateDescription(information);
        if (!updateDescription) CommonUtils.throwRuntimeException(AdministratorStatusEnum.BACKEND_ERROR);

        // update basic information
        if (information.getType().equals("crates")) {
            // update basic information except name
            Boolean updateInformation = adminItemManipulationMapper.updateCratesInformation(information);
            if (!updateInformation) CommonUtils.throwRuntimeException(AdministratorStatusEnum.BACKEND_ERROR);

            List<ItemName> cratesName = adminItemManipulationMapper.selectCratesId(information.getDescriptionId());
            cratesName.forEach(itemName -> {
                String amount = itemName.getName().split(" ")[0];
                itemName.setName(amount + " " + information.getName());
                System.out.println(itemName.getName());
            });

            // update name
            Boolean updateName = adminItemManipulationMapper.updateCratesInformationName(cratesName, information.getDescriptionId());
            if (!updateName) CommonUtils.throwRuntimeException(AdministratorStatusEnum.BACKEND_ERROR);
        } else if (information.getType().equals("extras")) {
            Boolean updateInformation = adminItemManipulationMapper.updateExtrasInformation(information);
            if (!updateInformation) CommonUtils.throwRuntimeException(AdministratorStatusEnum.BACKEND_ERROR);
        } else CommonUtils.throwRuntimeException(AdministratorStatusEnum.ITEM_TYPE_NOT_MATCH);
    }

    @Override
    public FileImageBO uploadImage(MultipartFile file, String category, String name) {
        // verify
        if (file == null) {
            CommonUtils.throwRuntimeException(AdministratorStatusEnum.FILE_NOT_FOUND);
        }

        // get origin name
        String originImageName = Objects.requireNonNull(file.getOriginalFilename()).toLowerCase();

        // verify again
        if (!originImageName.matches("^.+\\.(jpg|png|gif|jpeg|webp)$")) {
            CommonUtils.throwRuntimeException(AdministratorStatusEnum.EXTEND_NAME_NOT_MATCH);
        }
        try {
            BufferedImage imageInformation = ImageIO.read(file.getInputStream());
            int width = imageInformation.getWidth();
            int height = imageInformation.getHeight();
            if (width == 0 || height == 0) {
                CommonUtils.throwRuntimeException(AdministratorStatusEnum.IMAGE_INFORMATION_ERROR);
            }
        } catch (IOException e) {
            CommonUtils.throwRuntimeException(AdministratorStatusEnum.BACKEND_ERROR);
        }

        String categoryPath = category.toLowerCase();
        // todo 发布时切换
        // String imageDirectoryPath = projectPath + imageDirector;
        String imageDirectoryPath = testProjectPath + imageDirector;
        String imagePath = String.format("%s%s/", imageDirectoryPath, categoryPath);

        String imageType = originImageName.split("\\.")[1];
        String imageName = String.format("%s.%s", name.toLowerCase(), imageType);
        String absolutePath = String.format("%s%s", imagePath, imageName);

        File image = new File(absolutePath);
        File absolutePathExceptName = new File(imagePath);

        // check if the directory is exists
        if (!absolutePathExceptName.exists()) absolutePathExceptName.mkdirs();

        // if image exists then replace old one
        if (image.exists()) this.deleteImage(category, imageName);

        try {
            file.transferTo(image);
        } catch (IOException e) {
            CommonUtils.throwRuntimeException(AdministratorStatusEnum.BACKEND_ERROR);
        }

        String virtualPath = categoryPath + "/" + imageName;
        String urlPath = baseUrl + preUrl + imageDirector + virtualPath;

        return new FileImageBO(virtualPath, urlPath, imageName);
    }

    @Override
    public void unmountImage(String category, String name) {
        this.deleteImage(category, name);
    }


    private void deleteImage(String category, String name) {
        String imageAddress;
        if (name.contains(baseUrl)) {

            // todo 发布时替换
            imageAddress = name.replaceAll(baseUrl + preUrl, testProjectPath);
            // imageAddress = name.replaceAll(baseUrl + preUrl, projectPath);
        } else imageAddress = testProjectPath + imageDirector + category + "/" + name;
        // } else imageAddress = projectPath + imageDirector + category + "/" + name;

        File image = new File(imageAddress);
        if (image.exists()) {
            boolean isDeleted = image.delete();
            if (!isDeleted) CommonUtils.throwRuntimeException(AdministratorStatusEnum.BACKEND_ERROR);
        } else CommonUtils.throwRuntimeException(AdministratorStatusEnum.FILE_NOT_FOUND);
    }
}
