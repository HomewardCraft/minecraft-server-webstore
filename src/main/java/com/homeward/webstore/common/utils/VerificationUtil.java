package com.homeward.webstore.common.utils;

import com.homeward.webstore.mapper.StoreMapper;
import com.homeward.webstore.pojo.packages.ItemsList;
import com.mysql.cj.log.Log;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import reactor.util.annotation.Nullable;

@Slf4j
@Component
public class VerificationUtil {
    private final StoreMapper storeMapper;

    public VerificationUtil(StoreMapper storeMapper) {
        this.storeMapper = storeMapper;
    }

    /**
     * return true if the order exist.
     * @param itemId item id
     * @return Boolean
     * */
    public void itemExist(Integer itemId, String uuid) {
        String item = storeMapper.getItemName(itemId);
        if (item == null) {
            log.warn(uuid + " request a item which is not exist.");
            throw new RuntimeException("request item not exist!");
        }
    }
}
