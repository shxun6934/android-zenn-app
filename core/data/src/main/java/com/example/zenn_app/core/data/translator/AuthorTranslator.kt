package com.example.zenn_app.core.data.translator

import com.example.zenn_app.core.model.data.Author
import com.example.zenn_app.core.network.model.NetworkAuthor

object AuthorTranslator {

    fun NetworkAuthor.asExternalModel(): Author = Author(
        id = id,
        userName = username,
        name = name,
        avatarSmallUrl = avatarSmallUrl
    )
}
