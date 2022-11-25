package space.terwer.openkm.plugins.appstore.service.impl;

import org.springframework.stereotype.Service;
import space.terwer.openkm.common.plugin.api.PluginLogger;
import space.terwer.openkm.common.plugin.api.PluginLoggerFactory;
import space.terwer.openkm.plugins.appstore.service.IAppStoreService;
import space.terwer.openkm.plugins.appstore.AppStorePlugin;

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
