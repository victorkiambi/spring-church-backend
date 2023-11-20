package com.church.project.services

import com.church.project.dto.CommentDto
import com.church.project.repositories.CommentRepository
import com.church.project.utils.CustomPage
import com.church.project.utils.toPage
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service

@Service
class CommentService(
    val commentRepository: CommentRepository,
) {

    fun getComments(pageable: Pageable): CustomPage<CommentDto> {
        val comments = commentRepository.findAllByOrderByCreatedAtDesc(pageable).map {
            it.toDto()
        }
        return toPage(comments)
    }

    fun addComment(commentDto: CommentDto) = commentRepository.save(commentDto.toEntity()).toDto()

    fun getComment(id: Long) = commentRepository.findById(id).map {
        it.toDto()
    }
}