package com.example.zenn_app.core.domain.translator

import com.example.zenn_app.core.domain.model.TrendIdeaArticle
import com.example.zenn_app.core.domain.translator.DisplayAuthorTranslator.asAppModel
import com.example.zenn_app.core.domain.translator.DisplayPublicationTranslator.asAppModel
import com.example.zenn_app.core.model.data.Article

object TrendIdeaArticleTranslator {

    fun Article.asIdeaAppModel(): TrendIdeaArticle = TrendIdeaArticle(
        id = id,
        title = title,
        likedCount = likedCount,
        emoji = emoji,
        publishedAt = publishedAt,
        path = path,
        author = author.asAppModel(),
        publication = publication?.asAppModel()
    )
}
