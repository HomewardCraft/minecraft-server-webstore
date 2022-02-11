package com.homeward.webstore.util;

import com.homeward.webstore.mapper.OrderMapper;
import com.homeward.webstore.pojo.packages.ItemsList;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import reactor.util.annotation.Nullable;

@Component
public class VerificationUtil {
    private final OrderMapper orderMapper;

    public VerificationUtil(OrderMapper orderMapper) {
        this.orderMapper = orderMapper;
    }

    /**
     * return true if the order exist.
     * @param id item id
     * @param redirectPage the page you want user redirected empty string or null means no redirect
     * @param response http servlet response (can be null)
     * @return Boolean
     * */
    public Boolean orderExist(Integer id,@Nullable String redirectPage,@Nullable HttpServletResponse response) {
        ItemsList itemId = orderMapper.getItemId(id);
        if (itemId == null) {
            if (redirectPage != null) {
                try {
                    response.sendRedirect(redirectPage);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            return false;
        }
        return true;
    }
}
