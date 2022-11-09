package space.terwer.openkm.core.container;

import org.pf4j.ExtensionFactory;
import org.pf4j.spring.ExtensionsInjector;
import org.pf4j.spring.SpringPluginManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory;

import javax.annotation.PostConstruct;
import java.nio.file.Path;

/**
 * 核心插件管理器
 */
public class OpenkmPluginManager extends SpringPluginManager {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    public OpenkmPluginManager(Path pluginsRoot) {
        super(pluginsRoot);
    }

    public OpenkmPluginManager() {
        super();
    }

    @Override
    protected ExtensionFactory createExtensionFactory() {
        return super.createExtensionFactory();
    }

    @Override
    @PostConstruct
    public void init() {
        logger.info("初始化插件");
        super.loadPlugins();
        logger.info("启动插件");
        super.startPlugins();

        logger.info("注册插件到上下文");
        AbstractAutowireCapableBeanFactory beanFactory = (AbstractAutowireCapableBeanFactory) this.getApplicationContext().getAutowireCapableBeanFactory();
        ExtensionsInjector extensionsInjector = new ExtensionsInjector(this, beanFactory);
        extensionsInjector.injectExtensions();

        logger.info("插件初始化完毕");
    }
}
