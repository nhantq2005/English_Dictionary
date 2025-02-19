package com.example.englishdictionary.ui.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

@Composable
fun AppTheme(
    content: @Composable () -> Unit
) {
    val typography = AppTypography(
        title = TextStyle(
            fontFamily = RobotoFamily,
            fontWeight = FontWeight.Medium,
            fontSize = 35.sp
        ),
        partOfSpeech = TextStyle(
            fontFamily = RobotoFamily,
            fontWeight = FontWeight.Bold,
            fontSize = 12.sp
        ),
        word = TextStyle(
            fontFamily = RobotoFamily,
            fontWeight = FontWeight.SemiBold,
            fontSize = 35.sp
        ),
        navLabel = TextStyle(
            fontFamily = RobotoFamily,
            fontWeight = FontWeight.SemiBold,
            fontSize = 18.sp
        ),
        keyword = TextStyle(
            fontFamily = RobotoFamily,
            fontWeight = FontWeight.SemiBold,
            fontSize = 20.sp
        ),
        definition = TextStyle(
            fontFamily = RobotoFamily,
            fontWeight = FontWeight.Normal,
            fontSize = 16.sp
        ),
        placeholder = TextStyle(
            fontFamily = RobotoFamily,
            fontWeight = FontWeight.Normal,
            fontSize = 20.sp
        ),
        phonetic = TextStyle(
            fontFamily = RobotoFamily,
            fontWeight = FontWeight.Normal,
            fontSize = 13.sp
        )
    )

    val color = AppColor(
        partOfSpeech = Color(0xFF417097),
        bottomBar = Color(0xFFCFDEFF),
        header = Color(0xFFCFDEFF),
        background = Color(0xFFEDF3FF),
        key = Color(0xFF3F5A6B),
        iconButton = Color(0xFF417097),
        saveButton = Color(0xFFF1EA20),
        right = Color(0xFF36CC00),
        wrong = Color(0xFFEA3323),
        navIcon = Color(0xFF44464F),
        flashcard = Color.White,
        selectedItem = Color(0xFFC1CFEE),
        textField = Color(0xFFEDF3FF)
    )

    CompositionLocalProvider(
        LocalAppTypography provides typography,
        LocalAppColor provides color
    ) {
        content.invoke()
    }
}

object AppTheme{
    val appTypograhy:AppTypography
        @Composable
        get() = LocalAppTypography.current

    val appColor:AppColor
        @Composable
        get() = LocalAppColor.current
}