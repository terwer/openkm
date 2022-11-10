package space.terwer.plugins.appstore;


import org.pf4j.PluginWrapper;
import org.springframework.context.support.GenericApplicationContext;
import space.terwer.pluginapi.BasePlugin;
import space.terwer.pluginapi.PluginLogger;
import space.terwer.pluginapi.PluginLoggerFactory;
import space.terwer.plugins.appstore.front.AppStoreApi;
import space.terwer.plugins.appstore.front.AppStoreController;
import space.terwer.plugins.appstore.service.impl.AppStoreServiceImpl;

/**
 * Plugin endpoint
 */
public class AppStorePlugin extends BasePlugin {
    private final PluginLogger logger = PluginLoggerFactory.getLogger(AppStorePlugin.class, this.getClass());

    public AppStorePlugin(PluginWrapper wrapper) {
        super(wrapper);
    }

    @Override
    protected void registerBeans(GenericApplicationContext applicationContext) {
        applicationContext.registerBean(AppStoreController.class);
        logger.info("AppStorePluginExtension registerBean " + AppStoreController.class + " in applicationContext " + applicationContext);
        applicationContext.registerBean(AppStoreApi.class);
        logger.info("AppStorePluginExtension registerBean " + AppStoreApi.class + " in applicationContext " + applicationContext);
        applicationContext.registerBean(AppStoreServiceImpl.class);
        logger.info("AppStorePluginExtension registerBean " + AppStoreServiceImpl.class + " in applicationContext " + applicationContext);
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
