package com.tauyeung.userservice

import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import org.springframework.web.server.ResponseStatusException
import javax.validation.Valid
import javax.validation.constraints.NotNull
import javax.validation.constraints.Positive

@RestController
@RequestMapping("/users")
@Tag(name = "Users", description = "CRUD endpoints")
class UserController(private val repository: UserRepository) {
    @GetMapping("")
    @Operation(description = "Get all users")
    fun getUsers() = repository.findAll()

    @PostMapping("")
    @Operation(description = "Create user")
    fun createUser(
        @Valid
        @NotNull(message = "User is required")
        @RequestBody
        user: User
    ) = repository.save(user);

    @GetMapping("/{id}")
    @Operation(description = "Get user by id")
    fun getUser(
        @Positive
        @PathVariable("id")
        id: Long
    ) = repository.findById(id)
        .orElseThrow { ResponseStatusException(HttpStatus.NOT_FOUND, "User $id not found") }

    @DeleteMapping("/{id}")
    @Operation(description = "Delete user by id")
    fun deleteUser(
        @Positive
        @PathVariable("id")
        id: Long
    ) = repository.deleteById(id)
}