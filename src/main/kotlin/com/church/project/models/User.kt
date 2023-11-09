package com.church.project.models

import com.church.project.dto.UserDto
import com.fasterxml.jackson.annotation.JsonManagedReference
import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
@Table(name = "users")
class User(
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Long?,
        val username: String,
        val firstName: String,
        val lastName: String,
        val email: String,
        val password: String,
        val createdAt: LocalDateTime,
        val updatedAt: LocalDateTime,

        @OneToMany(mappedBy = "user")
        @JsonManagedReference
        val posts: List<Post> = emptyList(),

        @OneToMany(mappedBy = "user")
        val comments: List<Comment> = emptyList(),

){
        override fun toString(): String {
                return "User(id=$id, username='$username', firstName='$firstName', lastName='$lastName', email='$email', password='$password', createdAt=$createdAt, updatedAt=$updatedAt)"
        }

    fun toDto() = UserDto(
            id = id,
            username = username,
            firstName = firstName,
            lastName = lastName,
            email = email,
    )
}