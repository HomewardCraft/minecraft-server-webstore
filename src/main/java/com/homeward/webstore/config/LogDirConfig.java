package com.homeward.webstore.config;

import ch.qos.logback.core.PropertyDefinerBase;
import org.springframework.boot.system.ApplicationHome;
import org.springframework.stereotype.Component;

import java.io.File;

@Component
public class LogDirConfig extends PropertyDefinerBase {

    @Override
    public String getPropertyValue() {
        ApplicationHome applicationHome = new ApplicationHome();
        File applicationHomeDir = applicationHome.getDir();
        return String.format("%s/logs/", applicationHomeDir);
    }
}
