package com.church.project.dto
import com.church.project.models.User
import java.time.LocalDateTime

data class UserDto(
        val id: Long?,
        val username: String,
        val firstName: String,
        val lastName: String,
        val email: String,
)
{
    fun toEntity() = User(
            id = id,
            username = username,
            firstName = firstName,
            lastName = lastName,
            email = email,
            password = "",
            createdAt = LocalDateTime.now(),
            updatedAt = LocalDateTime.now(),

    )
}