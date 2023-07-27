package com.sandstonelauncher

import androidx.compose.material.Typography
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.platform.Font
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType

// TODO: Try to exclude src/main/res/font/ from git.

object Fonts {
    @Suppress("SpellCheckingInspection")
    object Lato {
        val Regular = FontFamily(Font("font/Lato-Regular.ttf", FontWeight.Normal))
        val Bold = FontFamily(Font("font/Lato-Bold.ttf", FontWeight.Normal))
    }
}

val typography = Typography(
    h1 = TextStyle(
        color = Color(200, 200, 200),
        fontSize = TextUnit(30f, TextUnitType.Sp),
        fontFamily = Fonts.Lato.Bold
    ),

    h2 = TextStyle(
        color = Color(200, 200, 200),
        fontSize = TextUnit(25f, TextUnitType.Sp),
        fontFamily = Fonts.Lato.Bold
    ),

    h3 = TextStyle(
        color = Color(200, 200, 200),
        fontSize = TextUnit(20f, TextUnitType.Sp),
        fontFamily = Fonts.Lato.Bold
    ),

    h4 = TextStyle(
        color = Color(200, 200, 200),
        fontSize = TextUnit(15f, TextUnitType.Sp),
        fontFamily = Fonts.Lato.Bold
    ),

    h5 = TextStyle(
        color = Color(200, 200, 200),
        fontSize = TextUnit(10f, TextUnitType.Sp),
        fontFamily = Fonts.Lato.Bold
    ),

    body1 = TextStyle(
        color = Color(180, 180, 180),
        fontSize = TextUnit(20f, TextUnitType.Sp),
        fontFamily = Fonts.Lato.Regular
    ),

    body2 = TextStyle(
        color = Color(180, 180, 180),
        fontSize = TextUnit(15f, TextUnitType.Sp),
        fontFamily = Fonts.Lato.Regular
    )
)