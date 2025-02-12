package com.example.englishdictionary.feature_dictionary.presentation.saved_words_screen

import com.example.englishdictionary.feature_dictionary.domain.model.WordItem

data class SavedWordState (
    val savedWords:List<WordItem> = emptyList(),
    val searchWord:List<WordItem> = emptyList(),
    val keyword:String = ""
)