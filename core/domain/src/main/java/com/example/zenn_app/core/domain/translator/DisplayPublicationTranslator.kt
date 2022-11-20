package com.example.zenn_app.core.domain.translator

import com.example.zenn_app.core.domain.model.DisplayPublication
import com.example.zenn_app.core.model.data.Publication

object DisplayPublicationTranslator {

    fun Publication.asAppModel(): DisplayPublication = DisplayPublication(
        id = id,
        displayName = displayName,
        avatarSmallUrl = avatarSmallUrl
    )
}
