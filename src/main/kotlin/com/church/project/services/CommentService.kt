package com.church.project.services

import com.church.project.dto.CommentDto
import com.church.project.repositories.CommentRepository
import org.springframework.stereotype.Service

@Service
class CommentService(
    val commentRepository: CommentRepository,
) {

    fun getComments() = commentRepository.findAll().map {
        it.toDto()
    }

    fun addComment(commentDto: CommentDto) = commentRepository.save(commentDto.toEntity()).toDto()

    fun getComment(id: Long) = commentRepository.findById(id).map {
        it.toDto()
    }
}