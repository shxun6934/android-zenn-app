package com.example.zenn_app.core.domain.model

import kotlinx.datetime.Clock
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

data class DummyArticle(
    override val id: Int,
    override val title: String,
    override val likedCount: Int,
    override val emoji: String,
    override val publishedAt: Instant,
    override val path: String,
    override val author: DisplayAuthor,
    override val publication: DisplayPublication?
) : Article() {

    companion object {
        fun dummy(): DummyArticle = DummyArticle(
            id = 1,
            title = "test article title",
            likedCount = 1,
            emoji = "😀",
            publishedAt = Clock.System.now(),
            path = "https://zenn.dev/",
            author = DisplayAuthor.dummy(),
            publication = DisplayPublication.dummy()
        )
    }
}
