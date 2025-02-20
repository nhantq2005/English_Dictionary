package com.example.englishdictionary.feature_dictionary.presentation.flashcard_screen

import com.example.englishdictionary.feature_dictionary.domain.model.WordItem

data class FlashcardState(
    val listWord:List<WordItem> = emptyList(),
    val trueWords:Int=0,
    val falseWords:Int=0
)