package com.tauyeung.userservice

import javax.persistence.*
import javax.validation.constraints.Email
import javax.validation.constraints.NotEmpty

@Entity
data class User(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long? = null,

    @NotEmpty
    val firstName: String,

    @NotEmpty
    val lastName: String,

    @Email
    @NotEmpty
    @Column(unique = true)
    val email: String
)