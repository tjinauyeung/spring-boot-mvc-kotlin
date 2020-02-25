package com.tauyeung.user.api.config

import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Controller

import com.tauyeung.user.api.repositories.UserRepository
import com.tauyeung.user.api.models.User

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