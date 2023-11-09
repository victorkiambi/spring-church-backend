package com.church.project.controllers

import com.church.project.dto.UserDto
import com.church.project.services.UserService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
class UserController(
        val userService: UserService
) {

    @GetMapping("/users")
    fun getUsers(): ResponseEntity<List<UserDto>> {
        return ResponseEntity.ok(userService.getUsers())
    }

    @PostMapping("/users")
    fun addUser(@RequestBody data: UserDto): UserDto {
        return userService.addUser(data)
    }

    @GetMapping("/users/{id}")
    fun getUser(@PathVariable("id") userId: Long): UserDto {
        return userService.getUser(userId)
    }

    @PostMapping("/users/{id}")
    fun updateUser(): String {
        return "PUT works"
    }


}