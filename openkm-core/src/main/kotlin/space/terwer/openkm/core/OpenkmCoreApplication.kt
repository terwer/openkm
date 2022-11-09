package space.terwer.openkm.core

import org.pf4j.PluginManager
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.ConfigurableApplicationContext

@SpringBootApplication
class OpenkmCoreApplication

fun main(args: Array<String>) {
    val applicationContext = runApplication<OpenkmCoreApplication>(*args)
    val pluginManager= applicationContext.getBean(PluginManager::class.java)

    pluginManager.stopPlugins()
}
