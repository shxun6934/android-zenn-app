package com.example.zenn_app.core.model.data

data class Publication(
    val id: Int,
    val name: String,
    val avatarSmallUrl: String?,
    val displayName: String,
    val avatarRegistered: Boolean
)
