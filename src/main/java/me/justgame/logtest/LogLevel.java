package me.justgame.logtest;

import org.slf4j.Logger;

/**
 * Created by xcl on 2017-03-06.
 */
public enum LogLevel {
    DEBUG{
        @Override
        void log(Logger logger, String message) {
            logger.debug(message);
        }
    },
    INFO{
        @Override
        void log(Logger logger, String message) {
            logger.info(message);
        }
    },
    WARN {
        @Override
        void log(Logger logger, String message) {
            logger.warn(message);
        }
    },
    ERROR {
        @Override
        void log(Logger logger, String message) {
            logger.error(message);
        }
    };

    abstract void log(Logger log, String message);
}
