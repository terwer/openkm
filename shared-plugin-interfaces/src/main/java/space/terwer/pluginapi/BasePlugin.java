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

    /**
     * 注册插件的bean，建议所有的插件实现此方法，请在插件实现此方法，用于注册插件依赖
     */
    protected abstract void registerBeans();

    /**
     * 创建上下文，这里把插件与容器的上文保持一致，便于交互
     *
     * @return
     */
    @Override
    protected ApplicationContext createApplicationContext() {
        logger.info("Creating BasePlugin applicationContext");
        SpringPluginManager springPluginManager = (SpringPluginManager) (this.getWrapper().getPluginManager());
        ApplicationContext applicationContext = springPluginManager.getApplicationContext();
        logger.info("BasePlugin applicationContext is:" + applicationContext);
        return applicationContext;
    }

    /**
     * 通用的插件启动方法
     */
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

    /**
     * 通用的插件停止方法
     */
    @Override
    public void stop() {
        try {
            super.stop();
        } catch (Exception e) {
            logger.error("插件停止发生异常", e);
        }
        logger.debug("插件已停止");
    }
}
