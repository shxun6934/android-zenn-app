package com.example.zenn_app.core.data.translator

import com.example.zenn_app.core.data.translator.AuthorTranslator.asExternalModel
import com.example.zenn_app.core.data.translator.PublicationTranslator.asExternalModel
import com.example.zenn_app.core.model.data.Article
import com.example.zenn_app.core.network.model.NetworkArticle

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
            author = user.asExternalModel(),
            publication = publication?.asExternalModel()
        )
}
