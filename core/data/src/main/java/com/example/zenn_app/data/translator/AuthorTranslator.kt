package com.example.zenn_app.data.translator

import com.example.zenn_app.model.data.Author
import com.example.zenn_app.network.model.NetworkAuthor

object AuthorTranslator {

    fun NetworkAuthor.asExternalModel(): Author = Author(
        id = id,
        userName = userName,
        name = name,
        avatarSmallUrl = avatarSmallUrl
    )
}
