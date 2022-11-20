package com.example.zenn_app.core.model.data

import kotlinx.datetime.Instant

data class Book(
    val id: Int,
    val title: String,
    val slug: String,
    val published: Boolean,
    val price: Int,
    val isSuspendingPrivate: Boolean,
    val likedCount: Int,
    val publishedAt: Instant,
    val bodyUpdatedAt: Instant?,
    val sourceRepoUpdatedAt: Instant?,
    val coverImageSmallUrl: String?,
    val path: String,
    val author: Author
)
