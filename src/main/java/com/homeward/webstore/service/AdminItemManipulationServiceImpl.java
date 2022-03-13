package com.homeward.webstore.service;

import com.homeward.webstore.common.enums.AdministratorStatusEnum;
import com.homeward.webstore.common.util.CommonUtils;
import com.homeward.webstore.java.bean.BO.FileImageBO;
import com.homeward.webstore.java.bean.PO.ItemWholeInfo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

@Service
@PropertySource("classpath:/directories.properties")
public class AdminItemManipulationServiceImpl implements AdminItemManipulationService{
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

    @Override
    public Long insertItem(ItemWholeInfo itemWholeInfo) {
        System.out.println(itemWholeInfo.toString());
        return null;
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

        String categoryPath = String.format("%ss/", category.toLowerCase());
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
}
