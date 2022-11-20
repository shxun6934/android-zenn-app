package com.example.zenn_app.core.domain.translator

import com.example.zenn_app.core.domain.model.TrendBook
import com.example.zenn_app.core.domain.translator.DisplayAuthorTranslator.asAppModel
import com.example.zenn_app.core.model.data.Book

object TrendBookTranslator {

    fun Book.asAppModel(): TrendBook = TrendBook(
        id = id,
        title = title,
        price = price,
        likedCount = likedCount,
        publishedAt = publishedAt,
        coverImageSmallUrl = coverImageSmallUrl,
        path = path,
        author = author.asAppModel()
    )
}
