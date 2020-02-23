package com.tauyeung.userservice

import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import org.springframework.web.server.ResponseStatusException
import javax.validation.constraints.Positive

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

    @PutMapping("/{id}")
    @Operation(description = "Update user")
    fun updateUser(
        @Positive
        @PathVariable("id")
        id: Long,

        @RequestBody
        request: User
    ) = repository.save(
        User(
            id = id,
            firstName = request.firstName,
            lastName = request.lastName,
            email = request.email
        )
    )

    @DeleteMapping("/{id}")
    @Operation(description = "Delete user by id")
    fun deleteUser(
        @Positive
        @PathVariable("id")
        id: Long
    ) = repository.deleteById(id)
}