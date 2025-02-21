package com.example.englishdictionary.feature_dictionary.presentation.main_screen

import com.example.englishdictionary.feature_dictionary.domain.model.WordItem

sealed class MainEvent {
    data class EnteredWord(val word:String):MainEvent()
    data class SaveWord(val wordItem: WordItem):MainEvent()
    object OnSearchClick:MainEvent()
    data class CheckWordExist(val word:String):MainEvent()
}