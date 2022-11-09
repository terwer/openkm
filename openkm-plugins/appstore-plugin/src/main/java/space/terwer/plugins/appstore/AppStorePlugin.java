package space.terwer.plugins.appstore;


import org.pf4j.PluginWrapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import space.terwer.pluginapi.BasePlugin;

/**
 * Plugin endpoint
 */
public class AppStorePlugin extends BasePlugin {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    public AppStorePlugin(PluginWrapper wrapper) {
        super(wrapper);
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
