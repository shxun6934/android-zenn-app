package com.example.zenn_app.core.data.translator

import com.example.zenn_app.core.data.translator.AuthorTranslator.asExternalModel
import com.example.zenn_app.core.model.data.Book
import com.example.zenn_app.core.network.model.NetworkBook

object BookTranslator {

    fun NetworkBook.asExternalModel(): Book = Book(
        id = id,
        title = title,
        slug = slug,
        published = published,
        price = price,
        isSuspendingPrivate = isSuspendingPrivate,
        likedCount = likedCount,
        publishedAt = publishedAt,
        bodyUpdatedAt = bodyUpdatedAt,
        sourceRepoUpdatedAt = sourceRepoUpdatedAt,
        coverImageSmallUrl = coverImageSmallUrl,
        path = path,
        author = author.asExternalModel()
    )
}
