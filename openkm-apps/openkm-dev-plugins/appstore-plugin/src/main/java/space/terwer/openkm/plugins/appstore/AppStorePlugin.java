package space.terwer.openkm.plugins.appstore;


import org.pf4j.PluginWrapper;
import space.terwer.openkm.common.plugin.api.BasePlugin;
import space.terwer.openkm.common.plugin.api.PluginLogger;
import space.terwer.openkm.common.plugin.api.PluginLoggerFactory;

/**
 * Plugin endpoint
 */
public class AppStorePlugin extends BasePlugin {
    private final PluginLogger logger = PluginLoggerFactory.getLogger(AppStorePlugin.class, this.getClass());

    public AppStorePlugin(PluginWrapper wrapper) {
        super(wrapper);
        super.autoRegisterBeans(this.getClass());
        logger.info("AppStorePlugin autoRegisterBeans finish");
    }

    @Override
    public void start() {
        super.start();
        logger.info("AppStorePlugin started");
    }

    @Override
    public void stop() {
        super.stop();
        logger.info("AppStorePlugin stoped");
    }
}
