package com.omkarcodes.chatx.presentation.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.omkarcodes.chatx.R

val Mulish = FontFamily(
    Font(R.font.mulish_regular),
    Font(R.font.mulish_italic, FontWeight.Normal,FontStyle.Italic),
    Font(R.font.mulish_bold, FontWeight.Bold),
    Font(R.font.mulish_semibold, FontWeight.SemiBold),
    Font(R.font.mulish_extra_bold, FontWeight.ExtraBold),
)
// Set of Material typography styles to start with
val Typography = Typography(
    h1 = TextStyle(
        fontFamily = Mulish,
        fontWeight = FontWeight.Bold,
        fontSize = 24.sp
    ),
    body1 = TextStyle(
        fontFamily = Mulish,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp
    ),
    defaultFontFamily = Mulish
)
