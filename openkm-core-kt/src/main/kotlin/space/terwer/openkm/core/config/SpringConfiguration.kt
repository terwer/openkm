package space.terwer.openkm.core.config

import org.pf4j.PluginManager
import org.pf4j.spring.SpringPluginManager
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

/**
 * Spring config
 *
 * @name: SpringConfiguration
 * @author: terwer
 * @date: 2022-11-03 15:49
 */
@Configuration
class SpringConfiguration {
    @Bean
    fun pluginManager(): PluginManager {
        return SpringPluginManager()
    }
}