package me.justgame.logtest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by xcl on 2017-03-06.
 */
public class LogTest {
    private static final Logger logger = LoggerFactory.getLogger(LogTest.class);

    public static void main(String[] args) {
        LogTest test = new LogTest();
        test.testLog("test a log");
    }

    public void testLog(String message) {
        LogUtil.log(this, LogLevel.DEBUG, message);

    }
}
