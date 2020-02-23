package com.tauyeung.userservice

import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Controller

@Controller
interface UserRepository : CrudRepository<User, Long>
