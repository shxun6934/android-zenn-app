package com.example.zenn_app.core.domain.model

import kotlinx.datetime.Instant

data class TrendBook(
    val id: Int,
    val title: String,
    val price: Int,
    val likedCount: Int,
    val publishedAt: Instant,
    val coverImageSmallUrl: String?,
    val path: String,
    val author: DisplayAuthor
)
