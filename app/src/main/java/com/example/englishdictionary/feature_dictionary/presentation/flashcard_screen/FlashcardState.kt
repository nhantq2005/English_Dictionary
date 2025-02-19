package com.example.englishdictionary.feature_dictionary.presentation.flashcard_screen

import com.example.englishdictionary.feature_dictionary.domain.model.WordItem

data class FlashcardState(
    val listWord:List<WordItem>,
    val trueWords:Int,
    val falseWords:Int
)