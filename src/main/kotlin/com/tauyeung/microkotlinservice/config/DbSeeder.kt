package com.tauyeung.microkotlinservice.config

import com.tauyeung.microkotlinservice.models.User
import com.tauyeung.microkotlinservice.repositories.UserRepository
import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Controller

@Controller
class DbSeeder(val repository: UserRepository) : CommandLineRunner {
    override fun run(vararg args: String?) {
        println("--- Seeding DB ---")

        repository.saveAll(
            listOf(
                User(firstName = "Tjin", lastName = "Au Yeung", email = "tjin@gmail.com"),
                User(firstName = "Yip", lastName = "Au Yeung", email = "yip@gmail.com"),
                User(firstName = "Leyi", lastName = "Au Yeung", email = "leyi@gmail.com")
            )
        )

        repository.findAll().forEach {
            println("User created $it.firstName $it.lastName")
        }

        println("--- DB seeded ---")
    }
}