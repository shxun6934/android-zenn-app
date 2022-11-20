package com.example.zenn_app.core.data.repository

import com.example.zenn_app.core.model.data.Article
import kotlinx.coroutines.flow.Flow

interface TrendIdeaArticleRepository {

    fun fetchTrendIdeaArticles(): Flow<List<Article>>
}
