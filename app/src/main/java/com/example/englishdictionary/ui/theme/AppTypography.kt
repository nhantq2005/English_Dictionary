package com.example.englishdictionary.ui.theme

import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.text.TextStyle

data class AppTypography (
    val word: TextStyle = TextStyle.Default,
    val partOfSpeech:TextStyle = TextStyle.Default,
    val definition:TextStyle= TextStyle.Default,
    val keyword:TextStyle= TextStyle.Default,
    val title:TextStyle= TextStyle.Default,
    val navLabel:TextStyle= TextStyle.Default
)

val LocalAppTypography = staticCompositionLocalOf {
    AppTypography()
}