package com.example.zenn_app.data.repository

import com.example.zenn_app.model.data.Article

interface TrendTechArticleRepository {

    suspend fun fetchTrendTechArticles(): List<Article>
}
