package com.homeward.webstore.config;

import ch.qos.logback.core.PropertyDefinerBase;
import com.mysql.cj.log.Log;
import org.springframework.boot.system.ApplicationHome;
import org.springframework.stereotype.Component;

import java.io.File;

@Component
public class LogDirConfig extends PropertyDefinerBase {
    private String LOG_HOME;

    @Override
    public String getPropertyValue() {
        ApplicationHome applicationHome = new ApplicationHome();
        File applicationHomeDir = applicationHome.getDir();
        LOG_HOME = String.format("%s/logs/", applicationHomeDir);
        return LOG_HOME;
    }
}
