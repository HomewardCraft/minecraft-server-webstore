package com.homeward.webstore;

import com.homeward.webstore.config.AspectConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@Import(AspectConfig.class)
@EnableCaching
@EnableAsync
@EnableTransactionManagement
public class WebstoreApplication {
    public static void main(String[] args) {
        SpringApplication.run(WebstoreApplication.class, args);
    }
}
