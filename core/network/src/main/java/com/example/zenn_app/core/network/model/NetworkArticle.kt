package com.example.zenn_app.core.network.model

import com.example.zenn_app.core.model.data.type.ArticleType
import com.example.zenn_app.core.network.model.util.ArticleTypeSerializer
import com.example.zenn_app.core.network.model.util.InstantSerializer
import kotlinx.datetime.Instant
import kotlinx.serialization.Serializable

@Serializable
data class NetworkArticle(
    val id: Int,
    val postType: String, // must "Article"
    val title: String,
    val slug: String,
    val published: Boolean,
    val commentsCount: Int,
    val likedCount: Int,
    val bodyLettersCount: Int,
    @Serializable(ArticleTypeSerializer::class)
    val articleType: ArticleType,
    val emoji: String,
    val isSuspendingPrivate: Boolean,
    @Serializable(InstantSerializer::class)
    val publishedAt: Instant,
    @Serializable(InstantSerializer::class)
    val bodyUpdatedAt: Instant?,
    @Serializable(InstantSerializer::class)
    val sourceRepoUpdatedAt: Instant?,
    val path: String,
    val user: NetworkAuthor,
    val publication: NetworkPublication? = null
)
