package space.terwer.pluginapi;

import org.pf4j.PluginRuntimeException;
import org.pf4j.PluginWrapper;
import org.pf4j.spring.SpringPlugin;
import org.pf4j.spring.SpringPluginManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;

/**
 * 插件基类，建议所有的插件都继承此类
 */
public abstract class BasePlugin extends SpringPlugin {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    public BasePlugin(PluginWrapper wrapper) {
        super(wrapper);
    }

    @Override
    protected ApplicationContext createApplicationContext() {
        logger.debug("Creating BasePlugin applicationContext");
        SpringPluginManager springPluginManager = (SpringPluginManager) (this.getWrapper().getPluginManager());
        ApplicationContext applicationContext = springPluginManager.getApplicationContext();
        logger.debug("BasePlugin applicationContext is:" + applicationContext);
        return applicationContext;
    }

    @Override
    public void start() {
        try {
            logger.debug("插件启动中...");
            super.start();
            logger.debug("插件已启动");
        } catch (Exception e) {
            throw new PluginRuntimeException("插件启动失败，请排查", e);
        }

    }

    @Override
    public void stop() {
        super.stop();
        logger.debug("插件已停止");
    }
}
