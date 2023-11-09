package com.church.project.dto

import com.church.project.models.Comment
import java.time.LocalDateTime

data class CommentDto(
    val id: Long?,
    val comments: String,
    val createdAt: LocalDateTime?,
    val updatedAt: LocalDateTime?,
    val user: UserDto? = null,
    val post: PostDto? = null,
    val isDeleted: Boolean?,
    val deletedAt: LocalDateTime?,
    val userId: Long,
    val postId: Long,
){
    fun toEntity() = Comment(
            id = id,
            comments = comments,
            createdAt = LocalDateTime.now(),
            updatedAt = updatedAt?.let { LocalDateTime.now() },
            user = user?.toEntity(),
            post = post?.toEntity(),
            isDeleted = isDeleted?:false,
            deletedAt = null,
            userId = userId,
            postId = postId,
    )
}
