package com.example.zenn_app.core.data.translator

import com.example.zenn_app.core.model.data.Publication
import com.example.zenn_app.core.network.model.NetworkPublication

object PublicationTranslator {

    fun NetworkPublication.asExternalModel(): Publication = Publication(
        id = id,
        name = name,
        avatarSmallUrl = avatarSmallUrl,
        displayName = displayName,
        avatarRegistered = avatarRegistered
    )
}
