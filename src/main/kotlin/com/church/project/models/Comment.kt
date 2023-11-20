package com.church.project.models

import com.church.project.dto.CommentDto
import com.fasterxml.jackson.annotation.JsonBackReference
import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
@Table(name = "comments")
class Comment(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long?,
    val comments: String,
    val createdAt: LocalDateTime,
    val updatedAt: LocalDateTime?,
    val deletedAt: LocalDateTime?,
    val isDeleted: Boolean,
    val userId: Long,
    val postId: Long,

    @ManyToOne
    @JoinColumn(name = "userId", insertable = false, updatable = false)
    val user: User?,

    @ManyToOne
    @JoinColumn(name = "postId", insertable = false, updatable = false)
    @JsonBackReference
    val post: UserPost?,
){
    override fun toString(): String {
        return "Comment(id=$id, comments='$comments', createdAt=$createdAt, updatedAt=$updatedAt, deletedAt=$deletedAt, isDeleted=$isDeleted)"
    }

    fun toDto() = CommentDto(
        id = id,
        comments = comments,
        createdAt = createdAt,
        updatedAt = updatedAt,
        deletedAt = null,
        isDeleted = isDeleted,
        userId = userId,
        postId = postId,
    )
}
