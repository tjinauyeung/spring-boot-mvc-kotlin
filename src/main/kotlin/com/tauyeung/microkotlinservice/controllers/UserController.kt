package com.tauyeung.microkotlinservice.controllers

import com.tauyeung.microkotlinservice.repositories.UserRepository
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.server.ResponseStatusException
import javax.validation.constraints.Positive

@RestController
@RequestMapping("/users")
class UserController(private val repository: UserRepository) {
    @GetMapping("")
    fun getUsers() = repository.findAll()

    @GetMapping("/{id}")
    fun getUser(
        @Positive
        @PathVariable("id")
        id: Long
    ) = repository.findById(id)
        .orElseThrow { ResponseStatusException(HttpStatus.NOT_FOUND, "User $id not found") }
}