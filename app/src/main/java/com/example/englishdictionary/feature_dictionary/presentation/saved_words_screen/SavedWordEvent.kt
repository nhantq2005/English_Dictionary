package com.example.englishdictionary.feature_dictionary.presentation.saved_words_screen

import com.example.englishdictionary.feature_dictionary.domain.model.WordItem

sealed class SavedWordEvent {
    data class UnsaveWord(val word:WordItem):SavedWordEvent()
    data class EnteredKeyword(val keyword:String):SavedWordEvent()
    data class FindWord(val keyword: String):SavedWordEvent()
}