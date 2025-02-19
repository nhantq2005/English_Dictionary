package com.example.englishdictionary.feature_dictionary.presentation.main_screen

import com.example.englishdictionary.feature_dictionary.domain.model.WordItem

sealed class MainEvent {
    data class enteredWord(val word:String):MainEvent()
    data class saveWord(val wordItem: WordItem):MainEvent()
    object onSearchClick:MainEvent()
}