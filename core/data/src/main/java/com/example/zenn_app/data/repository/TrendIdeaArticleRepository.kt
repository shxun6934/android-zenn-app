package com.example.zenn_app.data.repository

import com.example.zenn_app.model.data.Article

interface TrendIdeaArticleRepository {

    suspend fun fetchTrendIdeaArticles(): List<Article>
}
