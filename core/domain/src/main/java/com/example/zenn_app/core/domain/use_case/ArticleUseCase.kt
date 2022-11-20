package com.example.zenn_app.core.domain.use_case

import com.example.zenn_app.core.data.repository.TrendIdeaArticleRepository
import com.example.zenn_app.core.data.repository.TrendTechArticleRepository
import com.example.zenn_app.core.domain.model.TrendIdeaArticle
import com.example.zenn_app.core.domain.model.TrendTechArticle
import com.example.zenn_app.core.domain.translator.TrendIdeaArticleTranslator.asIdeaAppModel
import com.example.zenn_app.core.domain.translator.TrendTechArticleTranslator.asTechAppModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class ArticleUseCase @Inject constructor(
    private val techArticleRepository: TrendTechArticleRepository,
    private val ideaArticleRepository: TrendIdeaArticleRepository
) {
    fun fetchTrendTechArticles(): Flow<List<TrendTechArticle>> =
        techArticleRepository.fetchTrendTechArticles().map { articles ->
            articles.map { it.asTechAppModel() }
        }

    fun fetchTrendIdeaArticles(): Flow<List<TrendIdeaArticle>> =
        ideaArticleRepository.fetchTrendIdeaArticles().map { articles ->
            articles.map { it.asIdeaAppModel() }
        }
}
