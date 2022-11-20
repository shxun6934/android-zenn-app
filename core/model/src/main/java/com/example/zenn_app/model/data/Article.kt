package com.example.zenn_app.model.data

import com.example.zenn_app.model.data.type.ArticleType
import kotlinx.datetime.Instant

data class Article(
    val id: Int,
    val title: String,
    val slug: String,
    val published: Boolean,
    val commentsCount: Int,
    val likedCount: Int,
    val bodyLettersCount: Int,
    val articleType: ArticleType,
    val emoji: String,
    val isSuspendingPrivate: Boolean,
    val publishedAt: Instant,
    val bodyUpdatedAt: Instant?,
    val sourceRepoUpdatedAt: Instant?,
    val path: String,
    val author: Author,
    val publication: Publication?
)
