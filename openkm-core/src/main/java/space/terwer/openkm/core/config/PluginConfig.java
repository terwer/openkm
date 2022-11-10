package space.terwer.openkm.core.config;

import org.pf4j.PluginManager;
import org.pf4j.RuntimeMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import space.terwer.openkm.core.container.OpenkmPluginManager;
import space.terwer.openkm.core.property.GlobalValue;

import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Plugin config
 */
@ConditionalOnProperty(name = "openkm.plugin-switch", havingValue = "true")
@Configuration
public class PluginConfig {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    public PluginConfig() {
        logger.info("插件配置开始");
    }

    @Bean
    public PluginManager PluginManager() {
        boolean pluginSwitch = GlobalValue.pluginSwitch;
        logger.info("插件功能状态:" + (pluginSwitch ? "开启" : "关闭"));

        if (pluginSwitch) {
            String env = GlobalValue.env;
            String pluginsDir = GlobalValue.pluginDir;
            logger.info("当前插件目录为:" + pluginsDir);

            // 插件开启，先设置环境变量
            String mode = env.equals("dev") ? RuntimeMode.DEVELOPMENT.toString() : RuntimeMode.DEPLOYMENT.toString();
            System.setProperty("pf4j.mode", mode);
            System.setProperty("pf4j.pluginsDir", pluginsDir);

            // 创建插件管理器
            Path pluginsRoot = Paths.get(pluginsDir);
            logger.info("开始创建插件管理器，插件路径为：" + pluginsRoot.toUri());

            return new OpenkmPluginManager(pluginsRoot);
        }

        return new OpenkmPluginManager();
    }
}
