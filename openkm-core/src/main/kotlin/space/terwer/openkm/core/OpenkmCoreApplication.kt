package space.terwer.openkm.core

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class OpenkmCoreApplication

fun main(args: Array<String>) {
    runApplication<OpenkmCoreApplication>(*args)
}
