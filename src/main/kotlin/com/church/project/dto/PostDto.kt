package com.church.project.dto

import com.church.project.models.Post
import java.time.LocalDateTime

data class PostDto(
    val id: Long?,
    val title: String,
    val content: String,
    val createdAt: LocalDateTime?,
    val updatedAt: LocalDateTime?,
    val deletedAt: String?,
    val userId: Long?,
    val comments: List<CommentDto> = emptyList(),
    val user: UserDto?,
    ){
    fun toEntity() = Post(
        id = id,
        title = title,
        content = content,
        createdAt = LocalDateTime.now(),
        updatedAt = updatedAt?.let { LocalDateTime.now() },
        deletedAt = null,
        userId = userId,
        user = user?.toEntity(),
    )
}