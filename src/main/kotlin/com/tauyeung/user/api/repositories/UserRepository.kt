package com.tauyeung.user.api.repositories

import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Controller

import com.tauyeung.user.api.models.User

@Controller
interface UserRepository : CrudRepository<User, Long>
