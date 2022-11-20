package com.example.zenn_app.core.data.repository

import com.example.zenn_app.core.model.data.Article

interface TrendTechArticleRepository {

    suspend fun fetchTrendTechArticles(): List<Article>
}
