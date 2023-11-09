package com.church.project.controllers

import com.church.project.dto.PostDto
import com.church.project.services.PostService
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
class PostController(
    val postService: PostService,
) {
    @GetMapping("/posts")
    fun getPosts() = postService.getPosts()

    @GetMapping("/posts/{id}")
    fun getPost(@PathVariable id: Long): Optional<PostDto>? = postService.getPost(id)

    @PostMapping("/posts")
    fun addPost(@RequestBody postDto: PostDto) = postService.addPost(postDto)
}