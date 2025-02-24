package com.example.englishdictionary.feature_dictionary.presentation.detail_word_screen

import com.example.englishdictionary.feature_dictionary.domain.model.WordItem

data class DetailState(
    val wordItem: WordItem?=null,
    val isSavedWord:Boolean=true
)