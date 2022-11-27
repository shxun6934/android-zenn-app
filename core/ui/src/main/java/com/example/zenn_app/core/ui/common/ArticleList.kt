package com.example.zenn_app.core.ui.common

import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.zenn_app.core.domain.model.Article

@Composable
fun <T : Article> LazyListScope.articleListItems(
    items: List<T>,
    itemModifier: Modifier = Modifier,
    onItemClick: (item: T) -> Unit = {}
) = items(
    items = items,
    key = { item -> item.id },
    itemContent = { item ->
        ArticleListItem(
            modifier = itemModifier,
            item = item,
            onClick = { onItemClick(item) }
        )
    }
)
