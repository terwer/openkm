package space.terwer.plugins.auth;

import org.pf4j.PluginWrapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import space.terwer.pluginapi.BasePlugin;

/**
 * 插件入口
 */
public class AuthPlugin extends BasePlugin {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    public AuthPlugin(PluginWrapper wrapper) {
        super(wrapper);
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
