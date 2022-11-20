package com.example.zenn_app.data.repository

import com.example.zenn_app.data.translator.ArticleTranslator.asExternalModel
import com.example.zenn_app.model.data.Article
import com.example.zenn_app.network.ZennApi
import javax.inject.Inject

class TrendTechArticleRepositoryImpl @Inject constructor(
    private val zennApi: ZennApi
) : TrendTechArticleRepository {

    override suspend fun fetchTrendTechArticles(): List<Article> =
        zennApi.fetchTrendTechArticles().map { it.asExternalModel() }
}
