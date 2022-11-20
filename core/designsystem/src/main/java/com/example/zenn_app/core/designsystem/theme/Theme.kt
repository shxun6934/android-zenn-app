package com.example.zenn_app.core.designsystem.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.core.view.ViewCompat

private val DarkColorScheme = darkColorScheme(
    primary = Blue80,
    onPrimary = Blue20,
    primaryContainer = Blue30,
    onPrimaryContainer = Blue90,
    secondary = DarkBlue80,
    onSecondary = DarkBlue20,
    secondaryContainer = DarkBlue30,
    onSecondaryContainer = DarkBlue90,
    tertiary = CyanBlue80,
    onTertiary = CyanBlue20,
    tertiaryContainer = CyanBlue30,
    onTertiaryContainer = CyanBlue90,
    error = Red80,
    errorContainer = Red30,
    onError = Red20,
    onErrorContainer = Red90,
    background = BlueGray10,
    onBackground = BlueGray90,
    surface = BlueGray10,
    onSurface = BlueGray90,
    surfaceVariant = Gray30,
    onSurfaceVariant = Gray80,
    outline = Gray60,
    inverseOnSurface = BlueGray10,
    inverseSurface = BlueGray90,
    inversePrimary = Blue40,
    surfaceTint = Blue80,
    outlineVariant = Gray30,
    scrim = White
)

private val LightColorScheme = lightColorScheme(
    primary = Blue40,
    onPrimary = White,
    primaryContainer = Blue90,
    onPrimaryContainer = Blue10,
    secondary = DarkBlue40,
    onSecondary = White,
    secondaryContainer = DarkBlue90,
    onSecondaryContainer = DarkBlue10,
    tertiary = CyanBlue40,
    onTertiary = White,
    tertiaryContainer = CyanBlue90,
    onTertiaryContainer = CyanBlue10,
    error = Red40,
    errorContainer = Red90,
    onError = White,
    onErrorContainer = Red10,
    background = White,
    onBackground = BlueGray10,
    surface = White,
    onSurface = BlueGray10,
    surfaceVariant = Gray90,
    onSurfaceVariant = Gray30,
    outline = Gray50,
    inverseOnSurface = BlueGray95,
    inverseSurface = BlueGray20,
    inversePrimary = Blue80,
    surfaceTint = Blue40,
    outlineVariant = Gray80,
    scrim = White
)

@Composable
fun ZennAppTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = false,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }
        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }
    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            (view.context as Activity).window.statusBarColor = colorScheme.primary.toArgb()
            ViewCompat.getWindowInsetsController(view)?.isAppearanceLightStatusBars = darkTheme
        }
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}
