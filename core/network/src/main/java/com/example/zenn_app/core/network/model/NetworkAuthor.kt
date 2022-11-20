package com.example.zenn_app.core.network.model

import kotlinx.serialization.Serializable

@Serializable
data class NetworkAuthor(
    val id: Int,
    val userName: String,
    val name: String,
    val avatarSmallUrl: String?
)
