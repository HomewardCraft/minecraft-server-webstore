package com.homeward.webstore.config;

import ch.qos.logback.core.PropertyDefinerBase;
import com.homeward.webstore.WebstoreApplication;
import org.springframework.boot.system.ApplicationHome;
import org.springframework.stereotype.Component;

import java.io.File;

@Component
public class LogDirConfig extends PropertyDefinerBase {

    /**
     * 日志存放位置
     */
    private String LOG_HOME;

    /**
     * 获取jar包的位置
     *
     * @return LOG_HOME
     */
    @Override
    public String getPropertyValue() {
//        ApplicationHome applicationHome = new ApplicationHome(WebstoreApplication.class);
//        File logFile = applicationHome.getSource();
//        this.LOG_HOME = logFile.getParentFile().toString();
        this.LOG_HOME = "P:\\Projects\\webstore\\log";
        return this.LOG_HOME;
    }
}
