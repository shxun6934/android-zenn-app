package com.example.zenn_app.core.data.repository

import com.example.zenn_app.core.model.data.Article

interface TrendIdeaArticleRepository {

    suspend fun fetchTrendIdeaArticles(): List<Article>
}
