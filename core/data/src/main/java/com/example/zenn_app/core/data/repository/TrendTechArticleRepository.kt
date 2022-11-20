package com.example.zenn_app.core.data.repository

import com.example.zenn_app.core.model.data.Article
import kotlinx.coroutines.flow.Flow

interface TrendTechArticleRepository {

    fun fetchTrendTechArticles(): Flow<List<Article>>
}
