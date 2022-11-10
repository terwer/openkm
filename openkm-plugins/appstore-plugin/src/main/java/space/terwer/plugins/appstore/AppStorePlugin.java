package space.terwer.plugins.appstore;


import org.pf4j.PluginWrapper;
import space.terwer.pluginapi.BasePlugin;
import space.terwer.pluginapi.PluginLogger;
import space.terwer.pluginapi.PluginLoggerFactory;

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
