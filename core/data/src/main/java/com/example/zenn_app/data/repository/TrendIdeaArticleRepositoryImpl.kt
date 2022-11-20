package com.example.zenn_app.data.repository

import com.example.zenn_app.data.translator.ArticleTranslator.asExternalModel
import com.example.zenn_app.model.data.Article
import com.example.zenn_app.network.ZennApi
import javax.inject.Inject

class TrendIdeaArticleRepositoryImpl @Inject constructor(
    private val zennApi: ZennApi
) : TrendIdeaArticleRepository {

    override suspend fun fetchTrendIdeaArticles(): List<Article> =
        zennApi.fetchTrendIdeaArticles().map { it.asExternalModel() }
}
