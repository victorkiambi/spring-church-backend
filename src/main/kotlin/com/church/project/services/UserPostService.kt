package com.church.project.services

import com.church.project.dto.UserPostDto
import com.church.project.repositories.UserPostRepository
import com.church.project.utils.CustomPage
import com.church.project.utils.toPage
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service

@Service
class UserPostService(
    private val userPostRepository: UserPostRepository,
) {
    fun getUserPosts(pageable: Pageable): CustomPage<UserPostDto> {
        val posts = userPostRepository.findAllByOrderByCreatedAtDesc(pageable).map {
            it.toDto()
        }
        return toPage(posts)
    }

    fun addUserPost(postDto: UserPostDto): UserPostDto {
        val post = userPostRepository.save(postDto.toEntity())
        return post.toDto()
    }

    fun getUserPost(id: Long): UserPostDto {
        val post = userPostRepository.findById(id).map {
            it.toDto()
        }
        return post.get()
    }
}