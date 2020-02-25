package com.tauyeung.user.api.models

import javax.persistence.*
import javax.validation.constraints.Email
import javax.validation.constraints.NotBlank

@Entity
data class User(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long? = null,

    @field:NotBlank(message = "Please provide a firstName")
    val firstName: String,

    @field:NotBlank(message = "Please provide a lastName")
    val lastName: String,

    @field:Email
    @field:NotBlank(message = "Please provide an email")
    @Column(unique = true)
    val email: String
)