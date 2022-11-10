package space.terwer.plugins.appstore.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import space.terwer.pluginapi.PluginLogger;
import space.terwer.pluginapi.PluginLoggerFactory;
import space.terwer.plugins.appstore.AppStorePlugin;
import space.terwer.plugins.appstore.service.IAppStoreService;

/**
 * 业务实现
 *
 * @author Terwer
 * @version 1.0
 * 2018/12/19 22:10:47
 **/
@Service
public class AppStoreServiceImpl implements IAppStoreService {
    private final PluginLogger logger = PluginLoggerFactory.getLogger(AppStorePlugin.class, this.getClass());

    @Override
    public String getAppStoreInfo() {
        logger.info("获取插件信息");
        return "data from AppStoreServiceImpl";
    }
}
