package com.homeward.webstore.service;

import com.homeward.webstore.java.bean.BO.FileImageBO;
import com.homeward.webstore.java.bean.PO.ItemWholeInfo;
import org.springframework.web.multipart.MultipartFile;

public interface AdminItemManipulationService {
    Long insertItem(ItemWholeInfo itemWholeInfo);

    FileImageBO uploadImage(MultipartFile file, String category, String name);
}
