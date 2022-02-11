package com.homeward.webstore;

import com.homeward.webstore.util.JsonMap;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class WebstoreApplication {
    public static void main(String[] args) {
        SpringApplication.run(WebstoreApplication.class, args);
    }

    //注册rest template
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    //注册自己的json map工具类
    @Bean
    public JsonMap jsonMap() {
        return new JsonMap();
    }
}
