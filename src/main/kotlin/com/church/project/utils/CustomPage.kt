package com.church.project.utils

import org.springframework.data.domain.Page

data class CustomPage<T>(
    val page: Int,
    val size: Int,
    val totalElements: Long,
    val totalPages: Int,
    val content: List<T>,
    val isFirst: Boolean,
    val isLast: Boolean,
    val isEmpty: Boolean,
)
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