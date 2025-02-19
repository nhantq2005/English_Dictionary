package com.example.englishdictionary.feature_dictionary.presentation.main_screen

import com.example.englishdictionary.feature_dictionary.domain.model.WordItem

data class MainState(
    val isLoading: Boolean = false,
    val isSavedWord:Boolean = false,
    val searchWord: String = "",
    val wordItem: WordItem? = null
)