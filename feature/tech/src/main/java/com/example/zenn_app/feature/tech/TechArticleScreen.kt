package com.example.zenn_app.feature.tech

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.zenn_app.core.domain.model.TrendTechArticle
import com.example.zenn_app.core.ui.common.ContentsEmptyView
import com.example.zenn_app.core.ui.common.LoadingView
import com.example.zenn_app.core.ui.common.articleListItems

@Composable
fun TechArticleScreen(
    modifier: Modifier = Modifier,
    viewModel: TechArticleViewModel = hiltViewModel()
) {
    val uiState = viewModel.techArticleState.collectAsState()

    when (uiState.value) {
        is TechArticleViewModel.TrendTechArticleUiState.Loading -> {
            LoadingView(modifier)
        }
        is TechArticleViewModel.TrendTechArticleUiState.Success -> {
            val techArticles =
                (uiState.value as TechArticleViewModel.TrendTechArticleUiState.Success).trendTechArticles

            if (techArticles.isEmpty()) {
                ContentsEmptyView(modifier)
            } else {
                TrendTechArticleList(modifier = modifier, techArticles = techArticles)
            }
        }
    }
}

@Composable
private fun TrendTechArticleList(
    modifier: Modifier = Modifier,
    techArticles: List<TrendTechArticle>
) {
    Surface(
        modifier = modifier,
        color = MaterialTheme.colorScheme.primaryContainer
    ) {
        LazyColumn(
            modifier = Modifier.padding(start = 20.dp, top = 20.dp, end = 20.dp)
        ) {
            articleListItems(
                items = techArticles,
                onItemClick = {}
            )
        }
    }
}
