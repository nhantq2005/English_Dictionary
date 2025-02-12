package com.example.englishdictionary.feature_dictionary.presentation.saved_words_screen.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.englishdictionary.feature_dictionary.presentation.components.PartOfSpeechItem
import com.example.englishdictionary.feature_dictionary.presentation.components.SaveButton
import com.example.englishdictionary.ui.theme.AppTheme

@Composable
fun SavedWordItem(){
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
            .shadow(
                elevation = 5.dp,
                shape = RoundedCornerShape(10.dp)
            ),
        colors = CardDefaults.cardColors(Color.White)
    ) {
        Column(modifier = Modifier.padding(11.dp)) {
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "WORD",
                    style = AppTheme.appTypograhy.word.copy(fontSize = 30.sp)
                )
                SaveButton(size = 30.dp)
            }
            PartOfSpeechItem(partOfSpeech = "Noun")
            Spacer(modifier = Modifier.padding(3.dp))
            Text(text = "all the people living in a particular country, area, or place")
            Spacer(modifier = Modifier.padding(5.dp))
            PartOfSpeechItem(partOfSpeech = "Noun")
            Spacer(modifier = Modifier.padding(3.dp))
            Text(text = "all the people living in a particular country, area, or place")
        }

    }
}

@Preview(showBackground = true)
@Composable
fun PreviewSaveWordItem(){
    AppTheme {
        SavedWordItem()
    }
}