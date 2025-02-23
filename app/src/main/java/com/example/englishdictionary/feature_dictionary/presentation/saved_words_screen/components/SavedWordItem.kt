package com.example.englishdictionary.feature_dictionary.presentation.saved_words_screen.components

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
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
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.englishdictionary.feature_dictionary.domain.model.WordItem
import com.example.englishdictionary.feature_dictionary.presentation.components.PartOfSpeechItem
import com.example.englishdictionary.feature_dictionary.presentation.components.SaveButton
import com.example.englishdictionary.feature_dictionary.presentation.main_screen.components.MeaningItem
import com.example.englishdictionary.feature_dictionary.presentation.saved_words_screen.SavedWordEvent
import com.example.englishdictionary.feature_dictionary.presentation.saved_words_screen.SavedWordsViewModel
import com.example.englishdictionary.ui.theme.AppTheme
import com.example.englishdictionary.util.Screen

@Composable
fun SavedWordItem(
    wordItem: WordItem,
    viewModel: SavedWordsViewModel,
    navController: NavController
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
            .shadow(
                elevation = 5.dp,
                shape = RoundedCornerShape(10.dp)
            )
            .clickable {
                navController.navigate(
                    Screen.DetailScreen.route+
                        "?wordId=${wordItem.id}")
            },
        colors = CardDefaults.cardColors(Color.White)
    ) {
        Column(
            modifier = Modifier.padding(11.dp)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = wordItem.word,
                    style = AppTheme.appTypograhy.word.copy(fontSize = 30.sp)
                )
                SaveButton(size = 30.dp,isSaved = true) {
                    viewModel.onEvent(SavedWordEvent.UnsaveWord(wordItem))
                }
            }
//            LazyColum -> Error in size of Meaning
            wordItem.meanings.forEach { meaning ->
                Column() {
                    PartOfSpeechItem(
                        partOfSpeech = meaning.partOfSpeech
                    )
                    Spacer(modifier = Modifier.padding(vertical = 3.dp))
                    Text(
                        text = meaning.definitions.definition,
                        style = AppTheme.appTypograhy.definition
                    )
                }
                Spacer(modifier = Modifier.padding(vertical = 7.dp))
            }

        }

    }
}

@Preview(showBackground = true)
@Composable
fun PreviewSaveWordItem() {
    AppTheme {
//        SavedWordItem()
    }
}