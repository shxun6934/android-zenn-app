package com.example.zenn_app.data.translator

import com.example.zenn_app.data.translator.AuthorTranslator.asExternalModel
import com.example.zenn_app.data.translator.PublicationTranslator.asExternalModel
import com.example.zenn_app.model.data.Article
import com.example.zenn_app.network.model.NetworkArticle

object ArticleTranslator {

    fun NetworkArticle.asExternalModel(): Article =
        Article(
            id = id,
            title = title,
            slug = slug,
            published = published,
            commentsCount = commentsCount,
            likedCount = likedCount,
            bodyLettersCount = bodyLettersCount,
            articleType = articleType,
            emoji = emoji,
            isSuspendingPrivate = isSuspendingPrivate,
            publishedAt = publishedAt,
            bodyUpdatedAt = bodyUpdatedAt,
            sourceRepoUpdatedAt = sourceRepoUpdatedAt,
            path = path,
            author = author.asExternalModel(),
            publication = publication?.asExternalModel()
        )
}
