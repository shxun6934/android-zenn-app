package com.example.zenn_app.core.domain.model

import kotlinx.datetime.Instant

abstract class Article {
    abstract val id: Int
    abstract val title: String
    abstract val likedCount: Int
    abstract val emoji: String
    abstract val publishedAt: Instant
    abstract val path: String
    abstract val author: DisplayAuthor
    abstract val publication: DisplayPublication?
}
