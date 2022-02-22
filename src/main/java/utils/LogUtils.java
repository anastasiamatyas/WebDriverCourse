package utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LogUtils {
    private static final Logger LOGGER = LogManager.getLogger(LogUtils.class);
    private static LogUtils instance;

    public static LogUtils getInstance() {
        if (instance == null) {
            instance = new LogUtils();
        }
        return instance;
    }

    public void infoLog(String message) {
        LOGGER.info(message);
    }

    public void errorLog(String message) {
        LOGGER.error(message);
    }
}