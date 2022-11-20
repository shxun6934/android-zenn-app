package com.example.zenn_app.core.data.repository

import com.example.zenn_app.core.data.translator.ArticleTranslator.asExternalModel
import com.example.zenn_app.core.model.data.Article
import com.example.zenn_app.core.network.ZennApi
import javax.inject.Inject

class TrendIdeaArticleRepositoryImpl @Inject constructor(
    private val zennApi: ZennApi
) : TrendIdeaArticleRepository {

    override suspend fun fetchTrendIdeaArticles(): List<Article> =
        zennApi.fetchTrendIdeaArticles().map { it.asExternalModel() }
}
