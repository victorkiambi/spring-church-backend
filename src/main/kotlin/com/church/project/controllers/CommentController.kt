package com.church.project.controllers

import com.church.project.dto.CommentDto
import com.church.project.services.CommentService
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
class CommentController (
    val commentService: CommentService,
){

    @GetMapping("/comments")
    fun getComments() = commentService.getComments()

    @GetMapping("/comments/{id}")
    fun getComment(@PathVariable id: Long): Optional<CommentDto>? = commentService.getComment(id)

    @PostMapping("/comments")
    fun addComment(@RequestBody commentDto: CommentDto) = commentService.addComment(commentDto)
}