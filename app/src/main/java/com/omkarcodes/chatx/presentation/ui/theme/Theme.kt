package com.omkarcodes.chatx.presentation.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable

private val DarkColorPalette = darkColors(
    // Not set yet
    primary = colorBlue500,
    primaryVariant = colorBlue200,
    secondary = colorBlue300,
    background = ColorLightBackground,
    onBackground = colorLightText
)

private val LightColorPalette = lightColors(
    primary = colorBlue500,
    primaryVariant = colorBlue200,
    secondary = colorBlue300,
    background = ColorLightBackground,
    onBackground = colorLightText
    /* Other default colors to override

    surface = Color.White,
    onPrimary = Color.White,
    onSecondary = Color.Black,
    onBackground = Color.Black,
    onSurface = Color.Black,
    */
)

@Composable
fun ChatXTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable() () -> Unit) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}