package space.terwer.openkm.test;

import org.apache.commons.collections.CollectionUtils;
import org.pf4j.PluginManager;
import org.pf4j.PluginWrapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.ApplicationContext;
import space.terwer.openkm.common.GlobalValue;

import java.util.List;

@SpringBootApplication(scanBasePackages = {"space.terwer.openkm.test", "space.terwer.openkm.common"})
//@ConfigurationPropertiesScan(basePackages = {"space.terwer.openkm.common.property"})
public class OpenkmTestApplication {
    private static final Logger logger = LoggerFactory.getLogger(OpenkmTestApplication.class);

    public static void main(String[] args) {
        ApplicationContext applicationContext = SpringApplication.run(OpenkmTestApplication.class, args);

        if (GlobalValue.pluginSwitch) {
            PluginManager pluginManager = applicationContext.getBean(PluginManager.class);
            logger.info("找到 " + pluginManager.getPlugins().size() + " 个有效插件");

            if (CollectionUtils.isNotEmpty(pluginManager.getPlugins())) {
                List<PluginWrapper> plugins = pluginManager.getPlugins();
                plugins.forEach(p -> {
                    logger.info(p.getPluginId());
                });
            }
        } else {
            logger.warn("插件未启用，请在配置中开启");
        }
    }
}