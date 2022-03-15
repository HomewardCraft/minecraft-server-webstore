package com.homeward.webstore.service;

import com.alibaba.fastjson.JSONObject;
import com.homeward.webstore.common.enums.AdministratorStatusEnum;
import com.homeward.webstore.common.util.CommonUtils;
import com.homeward.webstore.java.bean.BO.FileImageBO;
import com.homeward.webstore.java.bean.PO.ItemWholeInfo;
import com.homeward.webstore.mapper.AdminItemManipulationMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.scheduling.annotation.Async;
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
    public FileImageBO uploadImage(MultipartFile file, String category, String name) {
        if (file == null) {
            CommonUtils.throwRuntimeException(AdministratorStatusEnum.FILE_NOT_FOUND);
        }

        String originImageName = Objects.requireNonNull(file.getOriginalFilename()).toLowerCase();
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
            CommonUtils.throwRuntimeException(AdministratorStatusEnum.IMAGE_INFORMATION_ERROR);
        }

        String categoryPath = category.toLowerCase();
        // String imageDirectoryPath = projectPath + imageDirector;
        // todo 发布时切换
        String imageDirectoryPath = testProjectPath + imageDirector;
        String imagePath = String.format("%s%s", imageDirectoryPath, categoryPath);

        String imageType = originImageName.split("\\.")[1];
        String imageName = String.format("%s.%s", name.toLowerCase(), imageType);
        String absolutePath = String.format("%s%s", imagePath, imageName);

        if (new File(absolutePath).exists()) {
            CommonUtils.throwRuntimeException(AdministratorStatusEnum.DUPLICATE_IMAGE);
        }

        try {
            file.transferTo(new File(absolutePath));
        } catch (IOException e) {
            CommonUtils.throwRuntimeException(AdministratorStatusEnum.IMAGE_CREATE_ERROR);
        }

        String virtualPath = categoryPath + imageName;
        String urlPath = baseUrl + preUrl + imageDirector + virtualPath;

        return new FileImageBO(virtualPath, urlPath, imageName);
    }


    @Override
    @Transactional
    public void insertItem(ItemWholeInfo information) {
        Long itemAmount = isExist(information.getName());
        if (itemAmount != 0) {
            CommonUtils.throwRuntimeException(AdministratorStatusEnum.ITEM_NAME_DUPLICATED);
        }

        information.setDescriptionId(UUID.randomUUID().toString());

        insertDescription(information);

        insertItemInformation(information);
    }

    @Async
    public void insertDescription(ItemWholeInfo information) {
        Boolean isComplete = adminItemManipulationMapper.insertDescription(information);
        if (!isComplete) {
            CommonUtils.throwRuntimeException(AdministratorStatusEnum.DESCRIPTION_INSERT_ERROR);
        }
    }

    @Async
    public void insertItemInformation(ItemWholeInfo information) {
        String type = information.getType().toLowerCase();
        if ("extras".equals(type)) {
            if (null == information.getRawSalePercent()) {
                information.setRawSalePercent("100");
            }
            information.setSalePercent(Integer.valueOf(information.getRawSalePercent() + ""));

            Boolean isComplete = adminItemManipulationMapper.insertItemInformation(information);
            if (!isComplete) {
                CommonUtils.throwRuntimeException(AdministratorStatusEnum.DESCRIPTION_INSERT_ERROR);
            }
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

                if (null == salePercent) {
                    information.setSalePercent(100);
                    information.setSaleCondition(false);
                } else {
                    information.setSalePercent(Integer.valueOf(salePercent + ""));
                    information.setSaleCondition(true);
                }
                informationList.add(information.clone());
            });

            informationList.sort(Comparator.comparing(ItemWholeInfo::getPrice));

            Boolean isComplete = adminItemManipulationMapper.insertItemInformationList(informationList);
            if (!isComplete) {
                CommonUtils.throwRuntimeException(AdministratorStatusEnum.INFORMATION_INSERT_ERROR);
            }
        } else {
            CommonUtils.throwRuntimeException(AdministratorStatusEnum.ITEM_TYPE_NOT_MATCH);
        }
    }

    public Long isExist(String name) {
        return adminItemManipulationMapper.isExist(name);
    }
}
