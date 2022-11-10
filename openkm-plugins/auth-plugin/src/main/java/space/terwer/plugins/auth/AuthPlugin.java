package space.terwer.plugins.auth;

import org.pf4j.PluginWrapper;
import space.terwer.pluginapi.BasePlugin;
import space.terwer.pluginapi.PluginLogger;
import space.terwer.pluginapi.PluginLoggerFactory;

/**
 * 插件入口
 */
public class AuthPlugin extends BasePlugin {
    private final PluginLogger logger = PluginLoggerFactory.getLogger(AuthPlugin.class, this.getClass());

    public AuthPlugin(PluginWrapper wrapper) {
        super(wrapper);
        this.registerBeans();
    }

    @Override
    protected void registerBeans() {
    }


    @Override
    public void start() {
        super.start();
        logger.info("AuthPlugin started");
    }

    @Override
    public void stop() {
        super.stop();
        logger.info("AuthPlugin stoped");
    }
}
