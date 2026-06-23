package npa.crategame.crategameinterface

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.ConfigurationPropertiesScan
import org.springframework.boot.runApplication

@SpringBootApplication
@ConfigurationPropertiesScan
class CrateGameInterfaceApplication

fun main(args: Array<String>) {
    runApplication<CrateGameInterfaceApplication>(*args)
    println("test")
}
