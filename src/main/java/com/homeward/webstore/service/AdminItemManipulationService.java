package com.homeward.webstore.service;

import com.homeward.webstore.java.bean.BO.FileImageBO;
import com.homeward.webstore.java.bean.PO.ItemWholeInfo;
import org.springframework.web.multipart.MultipartFile;

public interface AdminItemManipulationService {
    void insertItem(ItemWholeInfo itemWholeInfo);
    void updateItem(ItemWholeInfo itemWholeInfo);
    FileImageBO uploadImage(MultipartFile file, String category, String name);
    void unmountImage(String category, String name);
}
