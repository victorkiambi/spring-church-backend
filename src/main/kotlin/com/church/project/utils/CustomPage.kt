package com.church.project.utils

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
