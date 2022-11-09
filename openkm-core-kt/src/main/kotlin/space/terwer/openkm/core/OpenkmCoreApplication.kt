package space.terwer.openkm.core

import org.pf4j.PluginManager
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.boot.runApplication
import space.terwer.openkm.core.props.OpenkmConfig

@SpringBootApplication
@EnableConfigurationProperties
class OpenkmCoreApplication

fun main(args: Array<String>) {
    val applicationContext = runApplication<OpenkmCoreApplication>(*args)
    val pluginManager= applicationContext.getBean(PluginManager::class.java)

    pluginManager.stopPlugins()
}
