package com.example.englishdictionary.ui.theme

import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

data class AppColor(
    val partOfSpeech: Color = Color.Unspecified,
    val key: Color = Color.Unspecified,
    val iconButton: Color = Color.Unspecified,
    val bottomBar: Color = Color.Unspecified,
    val header: Color = Color.Unspecified,
    val background: Color = Color.Unspecified,
    val right: Color = Color.Unspecified,
    val wrong: Color = Color.Unspecified,
    val saveButton: Color = Color.Unspecified,
    val navIcon: Color = Color.Unspecified,
    val flashcard: Color = Color.Unspecified,
    val selectedItem: Color = Color.Unspecified,
    val textField:Color = Color.Unspecified
)

val LocalAppColor = staticCompositionLocalOf {
    AppColor()
}