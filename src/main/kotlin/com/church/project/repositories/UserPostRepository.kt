package com.church.project.repositories

import com.church.project.models.UserPost
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface UserPostRepository: JpaRepository<UserPost, Long>
{
    fun findAllByOrderByCreatedAtDesc(pageable: Pageable): Page<UserPost>
}