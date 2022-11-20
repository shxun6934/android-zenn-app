package com.example.zenn_app.core.domain.model

import kotlinx.datetime.Instant

data class TrendTechArticle(
    val id: Int,
    val title: String,
    val likedCount: Int,
    val emoji: String,
    val publishedAt: Instant,
    val path: String,
    val author: DisplayAuthor,
    val publication: DisplayPublication?
)
