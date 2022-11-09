package space.terwer.openkm.core;

import org.pf4j.PluginManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.ApplicationContext;
import space.terwer.openkm.core.property.GlobalValue;

@SpringBootApplication
@ConfigurationPropertiesScan(basePackages = {"space.terwer.openkm.core.property"})
public class OpenkmCoreApplication {
    private static final Logger logger = LoggerFactory.getLogger(OpenkmCoreApplication.class);

    public static void main(String[] args) {
        ApplicationContext applicationContext = SpringApplication.run(OpenkmCoreApplication.class, args);

        if (GlobalValue.pluginSwitch) {
            PluginManager pluginManager = applicationContext.getBean(PluginManager.class);
            logger.info("Find plugins:" + pluginManager.getPlugins().size());
        } else {
            logger.warn("Plugin not enabled");
        }
    }

}
