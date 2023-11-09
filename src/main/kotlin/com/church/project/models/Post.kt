package com.church.project.models

import com.church.project.dto.PostDto
import com.fasterxml.jackson.annotation.JsonBackReference
import com.fasterxml.jackson.annotation.JsonManagedReference
import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
@Table(name = "posts")
class Post(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long?,
    val title: String,
    val content: String,
    val createdAt: LocalDateTime,
    val updatedAt: LocalDateTime?,
    val deletedAt: LocalDateTime?,
    val userId: Long?,

    @ManyToOne
    @JoinColumn(name = "userId", insertable = false, updatable = false)
    @JsonBackReference
    val user: User?,

    @OneToMany(mappedBy = "post")
    @JsonManagedReference
    val comments: List<Comment> = emptyList(),
){

    override fun toString(): String {
        return "Post(id=$id, title='$title', content='$content', createdAt=$createdAt, updatedAt=$updatedAt, deletedAt=$deletedAt, userId=$userId)"
    }
    fun toDto() = PostDto(
        id = id,
        title = title,
        content = content,
        createdAt = createdAt,
        updatedAt = updatedAt,
        deletedAt = null,
        comments = comments.map { it.toDto() },
        userId = userId,
        user = user?.toDto(),
    )
}
