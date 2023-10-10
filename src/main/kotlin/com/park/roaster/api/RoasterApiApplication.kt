package com.park.roaster.api

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class RoasterApiApplication

fun main(args: Array<String>) {
    runApplication<RoasterApiApplication>(*args)
}
