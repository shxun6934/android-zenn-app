package com.example.zenn_app.core.network.model

import com.example.zenn_app.core.network.model.util.InstantSerializer
import kotlinx.datetime.Instant
import kotlinx.serialization.Serializable

@Serializable
data class NetworkBook(
    val id: Int,
    val postType: String, // must "Book"
    val title: String,
    val slug: String,
    val published: Boolean,
    val price: Int,
    val isSuspendingPrivate: Boolean,
    val likedCount: Int,
    @Serializable(InstantSerializer::class)
    val publishedAt: Instant,
    @Serializable(InstantSerializer::class)
    val bodyUpdatedAt: Instant?,
    @Serializable(InstantSerializer::class)
    val sourceRepoUpdatedAt: Instant?,
    val coverImageSmallUrl: String?,
    val path: String,
    val user: NetworkAuthor
)
