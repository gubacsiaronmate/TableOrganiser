package com.gubo.tableorganiser.ui.theme

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
import androidx.core.view.WindowCompat


private val DarkColorScheme = darkColorScheme(
    primary = Gray70,
    onPrimary = Gray10,
    primaryContainer = Gray80,
    onPrimaryContainer = Gray10,
    secondary = AccentGray,
    onSecondary = Gray10,
    secondaryContainer = Gray80,
    onSecondaryContainer = Gray10,
    tertiary = Black,
    onTertiary = White,
    tertiaryContainer = Gray80,
    onTertiaryContainer = Gray10,
    background = Gray90,
    onBackground = Gray10,
    surface = Gray90,
    onSurface = Gray10,
    surfaceVariant = Gray80,
    onSurfaceVariant = Gray30,
    outline = Gray70
)

private val LightColorScheme = lightColorScheme(
    primary = Gray30,
    onPrimary = Gray90,
    primaryContainer = Gray20,
    onPrimaryContainer = Gray90,
    secondary = AccentGray,
    onSecondary = Gray10,
    secondaryContainer = Gray20,
    onSecondaryContainer = Gray80,
    tertiary = Gray30,
    onTertiary = Gray90,
    tertiaryContainer = Gray20,
    onTertiaryContainer = Gray80,
    background = Gray10,
    onBackground = Gray90,
    surface = Gray10,
    onSurface = Gray90,
    surfaceVariant = Gray20,
    onSurfaceVariant = Gray70,
    outline = Gray30
)


@Composable
fun TableOrganiserTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }
        
        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }
    
    // Add status bar color customization
    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            val window = (view.context as Activity).window
            window.statusBarColor = colorScheme.background.toArgb()
            WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = !darkTheme
        }
    }
    
    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}