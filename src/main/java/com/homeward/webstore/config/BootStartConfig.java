package com.homeward.webstore.config;

import com.homeward.webstore.mapper.OrderMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
public class BootStartConfig implements InitializingBean {
    private final OrderMapper orderMapper;

    public BootStartConfig(OrderMapper orderMapper) {
        this.orderMapper = orderMapper;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        long rowAffected = orderMapper.initializeCart();
        String cartInitializeMessage = String.format("initialize completed, %srow(s) affected.", rowAffected);
        log.warn(cartInitializeMessage);
    }
}
