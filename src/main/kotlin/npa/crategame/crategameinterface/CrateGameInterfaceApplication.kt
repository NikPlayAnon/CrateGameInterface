package npa.crategame.crategameinterface

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class CrateGameInterfaceApplication

fun main(args: Array<String>) {
    runApplication<CrateGameInterfaceApplication>(*args)
    println("test")
}
