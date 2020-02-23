package com.tauyeung.userservice

import javax.persistence.*
import javax.validation.constraints.Email
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotEmpty

@Entity
data class User(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long? = null,

    @NotBlank(message = "Please provide a firstName")
    val firstName: String,

    @NotBlank(message = "Please provide a lastName")
    val lastName: String,

    @Email
    @NotBlank(message = "Please provide an email")
    @Column(unique = true)
    val email: String
)