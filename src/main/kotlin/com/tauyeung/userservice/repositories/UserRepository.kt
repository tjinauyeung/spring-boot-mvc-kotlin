package com.tauyeung.userservice.repositories

import com.tauyeung.userservice.models.User
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Controller

@Controller
interface UserRepository : CrudRepository<User, Long>
