package com.homeward.webstore.config;

import com.homeward.webstore.mapper.CartMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
public class BootStartConfig implements InitializingBean {
    private final CartMapper cartMapper;

    public BootStartConfig(CartMapper cartMapper) {
        this.cartMapper = cartMapper;
    }

    @Override
    public void afterPropertiesSet() {
        // long rowAffected = cartMapper.initializeCart();
        // String cartInitializeMessage = String.format("initialize player cart completed, %srow(s) affected.", rowAffected);
        // log.warn(cartInitializeMessage);
    }
}
