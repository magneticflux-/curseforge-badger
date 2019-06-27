package com.skaggsm.curseforgebadger

import com.skaggsm.curseforgebadger.curseforge.CurseForgeApiService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cache.annotation.EnableCaching
import org.springframework.stereotype.Component

@SpringBootApplication
@EnableCaching
class CurseForgeBadgerApplication

fun main(args: Array<String>) {
    runApplication<CurseForgeBadgerApplication>(*args)
}

@Component
class Tester : CommandLineRunner {

    @Autowired
    lateinit var service: CurseForgeApiService

    override fun run(vararg args: String?) {
        println(service.getProject("mumble-link-fabric"))
    }
}
