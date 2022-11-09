package space.terwer.openkm.core;

import org.pf4j.PluginManager;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.ApplicationContext;
import space.terwer.openkm.core.property.GlobalValue;

@SpringBootApplication
@ConfigurationPropertiesScan(basePackages = {"space.terwer.openkm.core.property"})
public class OpenkmCoreApplication {
    public static void main(String[] args) {
        ApplicationContext applicationContext = SpringApplication.run(OpenkmCoreApplication.class, args);

        if (GlobalValue.pluginSwitch) {
            PluginManager pluginManager = applicationContext.getBean(PluginManager.class);
            System.out.println("Find plugins:" + pluginManager.getPlugins().size());
            // pluginManager.stopPlugins();
        } else {
            System.out.println("Plugin not enabled");
        }

    }

}
