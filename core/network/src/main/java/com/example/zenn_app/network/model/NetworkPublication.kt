package com.example.zenn_app.network.model

import kotlinx.serialization.Serializable

@Serializable
data class NetworkPublication(
    val id: Int,
    val name: String,
    val avatarSmallUrl: String?,
    val displayName: String,
    val avatarRegistered: Boolean
)
