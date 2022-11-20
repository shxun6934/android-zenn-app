package com.example.zenn_app.core.domain.model

import kotlinx.datetime.Instant

data class TrendIdeaArticle(
    override val id: Int,
    override val title: String,
    override val likedCount: Int,
    override val emoji: String,
    override val publishedAt: Instant,
    override val path: String,
    override val author: DisplayAuthor,
    override val publication: DisplayPublication?
) : Article()
