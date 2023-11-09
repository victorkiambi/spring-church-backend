package com.church.project.services

import com.church.project.dto.UserDto
import com.church.project.repositories.UserRepository
import org.springframework.stereotype.Service

@Service
class UserService (
        val userRepository: UserRepository
){
    fun getUsers(): List<UserDto> {
        return userRepository.findAll().map { it.toDto() }
    }

    fun addUser(userDto: UserDto): UserDto {
        userRepository.save(userDto.toEntity())
        return userDto
    }

    fun getUser(userId: Long): UserDto {
        return userRepository.findById(userId).get().toDto()
    }
}