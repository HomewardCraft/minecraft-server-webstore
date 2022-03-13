package com.homeward.webstore.java.bean.BO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
public class FileImageBO {
    private String virtualPath;
    private String urlPath;
    private String fileName;
}
