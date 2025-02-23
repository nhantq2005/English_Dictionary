package com.example.englishdictionary.feature_dictionary.presentation.flashcard_screen.components

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.englishdictionary.feature_dictionary.domain.model.WordItem
import com.example.englishdictionary.feature_dictionary.presentation.components.PartOfSpeechItem
import com.example.englishdictionary.ui.theme.AppTheme
import com.example.englishdictionary.ui.theme.EnglishDictionaryTheme

@Composable
fun FlashCard(
    wordItem: WordItem
) {
    //Rotate flashcard value
    var flipped by rememberSaveable { mutableStateOf(false) }
    val rotation by animateFloatAsState(targetValue = if (flipped) 0f else 180f, label = "")
    val value = if (!flipped) -1f else 1f
    Card(
        //Rotate flashcard
        modifier = Modifier
            .fillMaxWidth(0.9f)
            .fillMaxHeight(0.7f)
            .graphicsLayer {
                rotationY = rotation
                cameraDistance = 8 * density
                scaleX = value
            }
            .clickable { flipped = !flipped },
        shape = RoundedCornerShape(20.dp),
        elevation = CardDefaults.cardElevation(15.dp),
        colors = CardDefaults.cardColors(
            containerColor = AppTheme.appColor.flashcard
        )
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .fillMaxSize()
                .padding(10.dp)
        ) {
            //Show definition of word
            if (flipped) {
                    Column(
                        modifier=Modifier.fillMaxSize()
                            .padding(5.dp),
                        verticalArrangement = Arrangement.Center
                    ) {
                        wordItem.meanings.forEach { meaning ->
                        PartOfSpeechItem(
                            partOfSpeech = meaning.partOfSpeech
                        )
                        Spacer(modifier = Modifier.padding(vertical = 5.dp))
                        Text(
                            text = meaning.definitions.definition,
                            style = AppTheme.appTypograhy.definition
                        )
                            Spacer(modifier = Modifier.padding(vertical = 7.dp))
                    }
                }
            } else {
                Text(text = wordItem.word, style = AppTheme.appTypograhy.word.copy(fontSize = 45.sp))
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun PreviewFlashCard() {
    EnglishDictionaryTheme {
//        FlashCard()
    }
}