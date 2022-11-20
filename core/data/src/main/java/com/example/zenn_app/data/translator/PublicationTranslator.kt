package com.example.zenn_app.data.translator

import com.example.zenn_app.model.data.Publication
import com.example.zenn_app.network.model.NetworkPublication

object PublicationTranslator {

    fun NetworkPublication.asExternalModel(): Publication = Publication(
        id = id,
        name = name,
        avatarSmallUrl = avatarSmallUrl,
        displayName = displayName,
        avatarRegistered = avatarRegistered
    )
}
