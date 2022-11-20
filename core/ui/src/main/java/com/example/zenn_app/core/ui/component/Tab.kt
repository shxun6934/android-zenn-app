package com.example.zenn_app.core.ui.component

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.zenn_app.core.designsystem.theme.ZennAppTheme

@Composable
fun ZennTabRow(
    selectedTabIndex: Int,
    modifier: Modifier = Modifier,
    tabs: @Composable () -> Unit
) {
    TabRow(
        selectedTabIndex = selectedTabIndex,
        modifier = modifier,
        contentColor = MaterialTheme.colorScheme.onSurfaceVariant,
        tabs = tabs
    )
}

@Composable
fun ZennTab(
    selected: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    text: @Composable () -> Unit,
    icon: @Composable (() -> Unit)? = null
) {
    Tab(
        selected = selected,
        onClick = onClick,
        modifier = modifier,
        enabled = enabled,
        text = text,
        icon = icon
    )
}

@Preview
@Composable
private fun PreviewZennTab() {
    var selectedItem by remember { mutableStateOf(0) }
    val items = listOf("Tech", "Idea")

    ZennAppTheme {
        ZennTabRow(selectedTabIndex = selectedItem) {
            items.forEachIndexed { index, item ->
                ZennTab(
                    selected = selectedItem == index,
                    onClick = { selectedItem = index },
                    text = { Text(text = item) }
                )
            }
        }
    }
}
