package com.example.zenn_app.core.ui.component

import androidx.compose.foundation.layout.RowScope
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Book
import androidx.compose.material.icons.filled.Lightbulb
import androidx.compose.material.icons.filled.MilitaryTech
import androidx.compose.material.icons.outlined.Book
import androidx.compose.material.icons.outlined.Lightbulb
import androidx.compose.material.icons.outlined.MilitaryTech
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.zenn_app.core.designsystem.theme.ZennAppTheme

@Composable
fun ZennNavigationBar(
    modifier: Modifier = Modifier,
    content: @Composable RowScope.() -> Unit
) {
    NavigationBar(
        modifier = modifier,
        tonalElevation = 0.dp,
        content = content
    )
}

@Composable
fun RowScope.ZennNavigationBarItem(
    selected: Boolean,
    onClick: () -> Unit,
    icon: @Composable () -> Unit,
    modifier: Modifier = Modifier,
    selectedIcon: @Composable () -> Unit = icon,
    enabled: Boolean = true,
    label: @Composable (() -> Unit)? = null,
    alwaysShowLabel: Boolean = true
) {
    NavigationBarItem(
        selected = selected,
        onClick = onClick,
        icon = if (selected) selectedIcon else icon,
        modifier = modifier,
        enabled = enabled,
        label = label,
        alwaysShowLabel = alwaysShowLabel,
    )
}

@Preview
@Composable
private fun PreviewZennNavigationBar() {
    var selectedItem by remember { mutableStateOf(0) }
    val items = listOf("Tech", "Idea", "Book")
    val icons = listOf(
        Icons.Default.MilitaryTech,
        Icons.Default.Lightbulb,
        Icons.Default.Book,
    )
    val selectedIcon = listOf(
        Icons.Outlined.MilitaryTech,
        Icons.Outlined.Lightbulb,
        Icons.Outlined.Book,
    )

    ZennAppTheme {
        ZennNavigationBar {
            items.forEachIndexed { index, item ->
                ZennNavigationBarItem(
                    selected = selectedItem == index,
                    onClick = { selectedItem = index },
                    icon = {
                        Icon(imageVector = icons[index], contentDescription = item)
                    },
                    selectedIcon = {
                        Icon(
                            imageVector = selectedIcon[index],
                            contentDescription = "$item selected"
                        )
                    },
                    label = { Text(text = item) }
                )
            }
        }
    }
}
