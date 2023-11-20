package com.church.project.controllers

import com.church.project.dto.UserPostDto
import com.church.project.services.UserPostService
import com.church.project.utils.CustomPage
import org.springframework.data.domain.Pageable
import org.springframework.web.bind.annotation.*

@RestController
class UserPostController(
    private val userPostService: UserPostService,
) {

    @GetMapping("/user-posts")
    fun getUserPosts(pageable: Pageable): CustomPage<UserPostDto> {
        return userPostService.getUserPosts(pageable)
    }

    @PostMapping("/user-posts")
    fun addUserPost(@RequestBody postDto: UserPostDto) {
        userPostService.addUserPost(postDto)
    }

    @GetMapping("/user-posts/{id}")
    fun getUserPost(@PathVariable id: Long): UserPostDto {
        return userPostService.getUserPost(id)
    }
}