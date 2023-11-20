package com.church.project.controllers

import com.church.project.dto.CommentDto
import com.church.project.services.CommentService
import org.springframework.web.bind.annotation.*
import java.util.*
import org.springframework.data.domain.Pageable
@RestController
class CommentController (
    val commentService: CommentService,
){

    @GetMapping("/comments")
    fun getComments(pageable: Pageable) = commentService.getComments(pageable)

    @GetMapping("/comments/{id}")
    fun getComment(@PathVariable id: Long): Optional<CommentDto>? = commentService.getComment(id)

    @PostMapping("/comments")
    fun addComment(@RequestBody commentDto: CommentDto) = commentService.addComment(commentDto)
}