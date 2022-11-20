package com.example.zenn_app.core.domain.translator

import com.example.zenn_app.core.domain.model.DisplayAuthor
import com.example.zenn_app.core.model.data.Author

object DisplayAuthorTranslator {

    fun Author.asAppModel(): DisplayAuthor = DisplayAuthor(
        id = id,
        displayName = name,
        avatarSmallUrl = avatarSmallUrl
    )
}
