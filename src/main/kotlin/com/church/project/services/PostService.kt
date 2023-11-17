package com.church.project.services

import com.church.project.dto.PostDto
import com.church.project.repositories.PostRepository
import com.church.project.utils.CustomPage
import org.slf4j.LoggerFactory
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import java.util.*

@Service
class PostService(
    val postRepository: PostRepository,
) {

    val logger: org.slf4j.Logger? = LoggerFactory.getLogger(PostService::class.java)

    fun getPosts(pageable: Pageable): CustomPage<PostDto> {
        val posts = postRepository.findAll(pageable).map {
            it.toDto()
        }
        return toPage(posts)
    }

    fun addPost(postDto: PostDto): PostDto {
        val post = postRepository.save(postDto.toEntity())
        return post.toDto()
    }

    fun getPost(id: Long): Optional<PostDto>? {
        val post = postRepository.findById(id).map {
            it.toDto()
        }
        logger?.info("getPost: $post")
        return post
    }

    fun <T> toPage(page: Page<T>): CustomPage<T> {
        return CustomPage(
            page = page.number,
            size = page.size,
            totalElements = page.totalElements,
            totalPages = page.totalPages,
            content = page.content,
            isFirst = page.isFirst,
            isLast = page.isLast,
            isEmpty = page.isEmpty,
        )
    }

}