package com.example.englishdictionary.feature_dictionary.presentation.detail_word_screen

import com.example.englishdictionary.feature_dictionary.domain.model.WordItem
import com.example.englishdictionary.feature_dictionary.presentation.main_screen.MainEvent

sealed class DetailEvent {
    data class SaveWord(val wordItem: WordItem) : DetailEvent()
    data class UnsaveWord(val wordItem: WordItem) : DetailEvent()
    data class CheckWordExist(val word:String): DetailEvent()
}