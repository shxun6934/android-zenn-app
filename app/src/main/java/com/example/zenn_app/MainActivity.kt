package com.example.zenn_app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.WindowInsetsSides
import androidx.compose.foundation.layout.consumedWindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.only
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.style.TextAlign
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.zenn_app.core.designsystem.icon.ZennIcon
import com.example.zenn_app.core.designsystem.theme.Gray95
import com.example.zenn_app.core.designsystem.theme.ZennAppTheme
import com.example.zenn_app.core.ui.component.ZennNavigationBar
import com.example.zenn_app.core.ui.component.ZennNavigationBarItem
import com.example.zenn_app.feature.tech.TechArticleScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        installSplashScreen()
        super.onCreate(savedInstanceState)

        setContent {
            ZennAppTheme {
                ZennApp()
            }
        }
    }

    @OptIn(ExperimentalMaterial3Api::class, ExperimentalLayoutApi::class)
    @Composable
    private fun ZennApp() {
        val navController = rememberNavController()

        Scaffold(
            contentWindowInsets = WindowInsets(0, 0, 0, 0),
            bottomBar = {
                ZennNavigationBar {
                    TopLevelDestination.values().asList().forEach { destination ->
                        val currentDestination =
                            navController.currentBackStackEntryAsState().value?.destination
                        val selected = currentDestination?.hierarchy?.any {
                            it.route?.contains(destination.name, true) ?: false
                        } ?: false

                        val icon = if (selected) {
                            destination.selectedIcon
                        } else {
                            destination.unselectedIcon
                        }

                        ZennNavigationBarItem(
                            selected = selected,
                            onClick = { navigateToTopLevelDestination(destination, navController) },
                            icon = {
                                Icon(
                                    imageVector = icon,
                                    contentDescription = if (selected) {
                                        "${destination.name} selected"
                                    } else {
                                        destination.name
                                    }
                                )
                            },
                            label = { Text(text = destination.title) }
                        )
                    }
                }
            }
        ) { padding ->
            Row(
                Modifier
                    .fillMaxSize()
                    .windowInsetsPadding(
                        WindowInsets.safeDrawing.only(
                            WindowInsetsSides.Horizontal
                        )
                    )
            ) {
                NavHost(
                    navController = navController,
                    startDestination = TopLevelDestination.TECH.name,
                    modifier = Modifier
                        .padding(padding)
                        .consumedWindowInsets(padding)
                ) {
                    composable(route = TopLevelDestination.TECH.name) {
                        TechArticleScreen(TopLevelDestination.TECH.title)
                    }
                    composable(route = TopLevelDestination.IDEA.name) {
                        // TODO
                        // IdeaArticleScreen()
                        Surface(
                            color = MaterialTheme.colorScheme.surfaceVariant
                        ) {
                            Text(
                                text = TopLevelDestination.IDEA.title,
                                style = MaterialTheme.typography.titleMedium,
                                modifier = Modifier.fillMaxSize(),
                                textAlign = TextAlign.Center
                            )
                        }
                    }
                    composable(route = TopLevelDestination.BOOK.name) {
                        // TODO
                        // BookScreen()
                        Surface(
                            color = Gray95
                        ) {
                            Text(
                                text = TopLevelDestination.BOOK.title,
                                style = MaterialTheme.typography.titleMedium,
                                modifier = Modifier.fillMaxSize(),
                                textAlign = TextAlign.Center
                            )
                        }
                    }
                }
            }
        }
    }

    private fun navigateToTopLevelDestination(
        topLevelDestination: TopLevelDestination,
        navController: NavHostController
    ) {
//    val topLevelNavOptions = navOptions {
//        popUpTo(navController.graph.findStartDestination().id) {
//            saveState = true
//        }
//        launchSingleTop = true
//        restoreState = true
//    }

        when (topLevelDestination) {
            TopLevelDestination.TECH -> navController.navigate(TopLevelDestination.TECH.name)
            TopLevelDestination.IDEA -> navController.navigate(TopLevelDestination.IDEA.name)
            TopLevelDestination.BOOK -> navController.navigate(TopLevelDestination.BOOK.name)
        }
    }

    private enum class TopLevelDestination(
        val selectedIcon: ImageVector,
        val unselectedIcon: ImageVector,
        val title: String,
    ) {
        TECH(
            selectedIcon = ZennIcon.TechBorder,
            unselectedIcon = ZennIcon.Tech,
            title = "Tech"
        ),
        IDEA(
            selectedIcon = ZennIcon.IdeaBorder,
            unselectedIcon = ZennIcon.Idea,
            title = "Idea"
        ),
        BOOK(
            selectedIcon = ZennIcon.BookBorder,
            unselectedIcon = ZennIcon.Book,
            title = "Book"
        )
    }
}
