package com.example.zenn_app.core.data.repository

import com.example.zenn_app.core.data.translator.ArticleTranslator.asExternalModel
import com.example.zenn_app.core.model.data.Article
import com.example.zenn_app.core.network.ZennApi
import javax.inject.Inject

class TrendTechArticleRepositoryImpl @Inject constructor(
    private val zennApi: ZennApi
) : TrendTechArticleRepository {

    override suspend fun fetchTrendTechArticles(): List<Article> =
        zennApi.fetchTrendTechArticles().map { it.asExternalModel() }
}
