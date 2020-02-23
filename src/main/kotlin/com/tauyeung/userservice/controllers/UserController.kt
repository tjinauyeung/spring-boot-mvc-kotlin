package com.tauyeung.userservice.controllers

import com.tauyeung.userservice.repositories.UserRepository
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.server.ResponseStatusException
import javax.validation.constraints.Positive

import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag

@RestController
@RequestMapping("/users")
@Tag(name = "Users", description = "CRUD endpoints")
class UserController(private val repository: UserRepository) {
    @GetMapping("")
    @Operation(description = "Get all users")
    fun getUsers() = repository.findAll()

    @GetMapping("/{id}")
    @Operation(description = "Get user by id")
    fun getUser(
        @Positive
        @PathVariable("id")
        id: Long
    ) = repository.findById(id)
        .orElseThrow { ResponseStatusException(HttpStatus.NOT_FOUND, "User $id not found") }
}