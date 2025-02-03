package com.example.englishdictionary.feature_dictionary.presentation.components

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.englishdictionary.ui.theme.EnglishDictionaryTheme

@Composable
fun PartOfSpeechItem(partOfSpeech: String) {
    Card(
        colors = CardDefaults.cardColors(Color(0xFF417097)),
        shape = RoundedCornerShape(15.dp)
    ) {
        Text(
            text = partOfSpeech,
            fontWeight = FontWeight.SemiBold,
            color = Color.White,
            modifier = Modifier
                .padding(
                    horizontal = 20.dp,
                    vertical = 7.dp
                )
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewPartOfSpeechItem() {
    EnglishDictionaryTheme {
        PartOfSpeechItem("Noun")
    }
}