package space.terwer.openkm.common.plugin.api;

import org.slf4j.Logger;

/**
 * 插件日志管理器
 *
 * @name: PluginLogger
 * @author: terwer
 * @date: 2022-11-10 14:04
 **/
public class PluginLogger {
    private final Class<?> pluginClazz;
    private final Logger logger;

    public PluginLogger(Class<?> pluginClazz, Logger logger) {
        this.pluginClazz = pluginClazz;
        this.logger = logger;
    }

    private String formatMsg(String s) {
        return String.format("【%s】%s", this.pluginClazz.getName(), s);
    }

    public void trace(String s) {
        logger.trace(formatMsg(s));
    }

    public void trace(String s, Object o) {
        logger.trace(formatMsg(s), o);
    }

    public void trace(String s, Object o, Object o1) {
        logger.trace(formatMsg(s), o, o1);
    }

    public void trace(String s, Object... objects) {
        logger.trace(formatMsg(s), objects);
    }

    public void trace(String s, Throwable throwable) {
        logger.trace(formatMsg(s), throwable);
    }

    public void debug(String s) {
        logger.debug(formatMsg(s));
    }

    public void debug(String s, Object o) {
        logger.debug(formatMsg(s), o);
    }

    public void debug(String s, Object o, Object o1) {
        logger.debug(formatMsg(s), o, o1);
    }

    public void debug(String s, Object... objects) {
        logger.debug(formatMsg(s), objects);
    }

    public void debug(String s, Throwable throwable) {
        logger.debug(formatMsg(s), throwable);
    }

    public void info(String s) {
        logger.info(formatMsg(s));
    }

    public void info(String s, Object o) {
        logger.info(formatMsg(s), o);
    }

    public void info(String s, Object o, Object o1) {
        logger.info(formatMsg(s), o, o1);
    }

    public void info(String s, Object... objects) {
        logger.info(formatMsg(s), objects);
    }

    public void info(String s, Throwable throwable) {
        logger.info(formatMsg(s), throwable);
    }

    public void warn(String s) {
        logger.warn(formatMsg(s));
    }

    public void warn(String s, Object o) {
        logger.warn(formatMsg(s), o);
    }

    public void warn(String s, Object o, Object o1) {
        logger.warn(formatMsg(s), o, o1);
    }

    public void warn(String s, Object... objects) {
        logger.warn(formatMsg(s), objects);
    }

    public void warn(String s, Throwable throwable) {
        logger.warn(formatMsg(s), throwable);
    }

    public void error(String s) {
        logger.error(formatMsg(s));
    }

    public void error(String s, Object o) {
        logger.error(formatMsg(s), o);
    }

    public void error(String s, Object o, Object o1) {
        logger.error(formatMsg(s), o, o1);
    }

    public void error(String s, Object... objects) {
        logger.error(formatMsg(s), objects);
    }

    public void error(String s, Throwable throwable) {
        logger.error(formatMsg(s), throwable);
    }
}
