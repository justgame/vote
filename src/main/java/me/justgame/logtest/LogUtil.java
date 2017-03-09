package me.justgame.logtest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by xcl on 2017-03-06.
 */
public class LogUtil {

    public static <T> void log(T t, LogLevel level, String message) {
        Logger logger = LoggerFactory.getLogger(t.getClass());
        level.log(logger, message);
    }

    public static void log(Class clazz, LogLevel level, String message) {
        Logger logger = LoggerFactory.getLogger(clazz);
        level.log(logger, message);
    }
}
