package com.tauyeung.microkotlinservice.repositories

import com.tauyeung.microkotlinservice.models.User
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Controller

@Controller
interface UserRepository : CrudRepository<User, Long>
