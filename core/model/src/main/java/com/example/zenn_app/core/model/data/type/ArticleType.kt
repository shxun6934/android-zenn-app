package com.example.zenn_app.core.model.data.type

enum class ArticleType(val identifier: String) {
    TECH("tech"),
    IDEA("idea");

    companion object {
        fun findIdentifier(identifier: String): ArticleType = values().first { it.identifier == identifier }
    }
}
