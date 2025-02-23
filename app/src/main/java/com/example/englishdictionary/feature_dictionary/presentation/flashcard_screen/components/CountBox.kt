package com.example.englishdictionary.feature_dictionary.presentation.flashcard_screen.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.englishdictionary.ui.theme.AppTheme

@Composable
fun CountBox(
    countValue: Int,
    color: Color
) {
    Box(
        modifier = Modifier
            .shadow(10.dp, RoundedCornerShape(18.dp))
            .background(Color.White, RoundedCornerShape(5.dp))
    ) {
        Text(
            text = "$countValue",
            color = color,
            style = AppTheme.appTypograhy.countValue,
            modifier = Modifier
                .padding(15.dp)

        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewCountBox() {
    AppTheme {
        CountBox(countValue = 1, color = AppTheme.appColor.wrong)
    }
}