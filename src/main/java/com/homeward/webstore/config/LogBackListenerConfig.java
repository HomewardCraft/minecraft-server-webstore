package com.homeward.webstore.config;

import ch.qos.logback.core.status.Status;
import ch.qos.logback.core.status.StatusListener;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
public class LogBackListenerConfig implements StatusListener {
    @Override
    public void addStatusEvent(Status status) {

    }
}
