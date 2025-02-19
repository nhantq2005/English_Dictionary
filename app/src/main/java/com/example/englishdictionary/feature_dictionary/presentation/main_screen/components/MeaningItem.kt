package com.example.englishdictionary.feature_dictionary.presentation.main_screen.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.englishdictionary.feature_dictionary.domain.model.Meaning
import com.example.englishdictionary.feature_dictionary.presentation.components.Item
import com.example.englishdictionary.feature_dictionary.presentation.components.PartOfSpeechItem

@Composable
fun MeaningItem(
    meaning: Meaning,
) {
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        PartOfSpeechItem(partOfSpeech = meaning.partOfSpeech)
        Spacer(modifier = Modifier.padding(7.dp))
        if (meaning.definitions.definition.isNotEmpty()) {
            Item(key = "Definition", value = meaning.definitions.definition)
            Spacer(modifier = Modifier.padding(7.dp))
        }
        if (meaning.definitions.example.isNotEmpty()) {
            Item(key = "Example", value = meaning.definitions.example)
            Spacer(modifier = Modifier.padding(7.dp))
        }
        if (meaning.synonyms?.isNotEmpty() == true) {
            Item(key = "Synonyms", value = meaning.synonyms.joinToString(", "))
            Spacer(modifier = Modifier.padding(7.dp))
        }
        if (meaning.antonyms?.isNotEmpty() == true) {
            Item(key = "Antonyms", value = meaning.antonyms.joinToString(", "))
            Spacer(modifier = Modifier.padding(7.dp))
        }
    }
}
