package com.example.zenn_app.core.data.repository

import com.example.zenn_app.core.data.translator.ArticleTranslator.asExternalModel
import com.example.zenn_app.core.model.data.Article
import com.example.zenn_app.core.network.ZennApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class TrendIdeaArticleRepositoryImpl @Inject constructor(
    private val zennApi: ZennApi
) : TrendIdeaArticleRepository {

    override fun fetchTrendIdeaArticles(): Flow<List<Article>> = flow {
        emit(zennApi.fetchTrendIdeaArticles().map { it.asExternalModel() })
    }.flowOn(Dispatchers.IO)
}
