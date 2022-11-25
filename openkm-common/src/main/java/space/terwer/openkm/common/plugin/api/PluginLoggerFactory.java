package space.terwer.openkm.common.plugin.api;

import org.slf4j.LoggerFactory;

/**
 * 插件日志工厂
 *
 * @name: PluginLoggerFactory
 * @author: terwer
 * @date: 2022-11-10 14:03
 **/
public class PluginLoggerFactory {
    /**
     * 插件日志记录器
     *
     * @param pluginClazz
     * @param clazz
     * @return
     */
    public static PluginLogger getLogger(Class<?> pluginClazz, Class<?> clazz) {
        return new PluginLogger(pluginClazz, LoggerFactory.getLogger(clazz));
    }

    /**
     * 已废弃，推荐使用 getLogger(Class<BasePlugin> pluginClazz, Class<?> clazz) ，可以区分插件日志
     *
     * @param clazz
     * @return
     */
    @Deprecated
    public static PluginLogger getLogger(Class<?> clazz) {
        return new PluginLogger(BasePlugin.class, LoggerFactory.getLogger(clazz));
    }
}
