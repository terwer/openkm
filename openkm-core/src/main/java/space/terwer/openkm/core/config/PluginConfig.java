package space.terwer.openkm.core.config;

import org.pf4j.PluginManager;
import org.pf4j.spring.SpringPluginManager;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Plugin config
 */
@ConditionalOnProperty(name = "openkm.plugin-switch", havingValue = "true")
@Configuration
public class PluginConfig {
    @Bean
    public PluginManager PluginManager() {
        return new SpringPluginManager();
    }
}
