package com.example.zenn_app.feature.tech

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.zenn_app.core.domain.model.TrendTechArticle
import com.example.zenn_app.core.domain.use_case.ArticleUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
class TechArticleViewModel @Inject constructor(
    useCase: ArticleUseCase
) : ViewModel() {

    sealed interface TrendTechArticleUiState {
        object Loading : TrendTechArticleUiState

        data class Success(
            val trendTechArticles: List<TrendTechArticle>
        ) : TrendTechArticleUiState
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    val techArticleState: StateFlow<TrendTechArticleUiState> =
        useCase.fetchTrendTechArticles().flatMapLatest { articles ->
            flowOf(TrendTechArticleUiState.Success(articles))
        }.stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5_000),
            initialValue = TrendTechArticleUiState.Loading
        )
}
