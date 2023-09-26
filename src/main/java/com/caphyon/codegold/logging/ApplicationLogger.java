package com.caphyon.codegold.logging;

import java.util.logging.Level;
import java.util.logging.Logger;

public class ApplicationLogger {
    private Logger logger = Logger.getLogger(ApplicationLogger.class.getName());
    private static ApplicationLogger instance = new ApplicationLogger();

    public static ApplicationLogger getInstance() {
        return instance;
    }

    private ApplicationLogger() {
    }

    public void Log(String message) {
        instance.logger.log(Level.INFO, message);
    }

    public void LogError(String message, Throwable t) {
        instance.logger.log(Level.SEVERE, message, t);
    }
}
