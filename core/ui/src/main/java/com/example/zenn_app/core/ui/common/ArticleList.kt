package com.example.zenn_app.core.ui.common

import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.runtime.Composable
import com.example.zenn_app.core.domain.model.Article

@Composable
fun <T : Article> LazyListScope.ArticleListItems(
    items: List<T>,
    onItemClick: (item: T) -> Unit = {},
) {
    // TODO
}
