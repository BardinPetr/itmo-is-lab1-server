package ru.bardinpetr.itmo.islab1

import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.ConfigurationPropertiesScan
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import ru.bardinpetr.itmo.islab1.common.utils.logger
import ru.bardinpetr.itmo.islab1.app.location.model.Location
import ru.bardinpetr.itmo.islab1.app.location.repository.LocationRepository

@SpringBootApplication
@EnableConfigurationProperties
@ConfigurationPropertiesScan
class ItmoIsLab1Application {
    val log = logger<ItmoIsLab1Application>()

    @Bean
    fun demo(repo: LocationRepository) = CommandLineRunner {
        for (i in 1..99)
            for (j in 1..99)
                repo.save(Location(i.toLong(), j, (i * 1000 + j).toLong(), ((i * 1000) + j).toString()))

//        val a = Location(1,2,3, "test0")
//        val b = Location(10,20,30, "test1")
//        repo.save(a)
//        repo.save(b)
//
//        a.x= 111
//        b.y=3123
//
//        repo.save(a)
//        repo.save(b)

//        val a = Organization(
//            "test",
//            employeesCount = 213,
//            fullName = "esa"
//        )
//        r2.save(a)
//        a.fullName= "ASDDASD"
//        r2.save(a)

//        val a = repo.findRevisions(repo.findFirstByName("test1").id!!)
//        log.info(aus.toString())
//        val res = aus.getEntityAuditLog()
//        log.info(res.toString())
//        val res2 = aus.getEntityAuditLog(3)
//        log.info(res2.toString())
//        val res4 = aus.getEntityAuditLog(532)
//        log.info(res4.toString())
    }
}

fun main(args: Array<String>) {
    runApplication<ItmoIsLab1Application>(*args)
}