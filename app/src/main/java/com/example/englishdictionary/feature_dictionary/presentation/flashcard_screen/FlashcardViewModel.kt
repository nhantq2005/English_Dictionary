package com.example.englishdictionary.feature_dictionary.presentation.flashcard_screen

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.ViewModel
import com.example.englishdictionary.feature_dictionary.presentation.saved_words_screen.SavedWordState
import com.example.englishdictionary.feature_dictionary.presentation.saved_words_screen.SavedWordsViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class FlashcardViewModel @Inject constructor(
):ViewModel() {


    private val _flashcardState = mutableStateOf(FlashcardState())
    val flashcardState:State<FlashcardState> = _flashcardState



    init {
        _flashcardState.value = flashcardState.value.copy(
            trueWords = 0,
            falseWords = 0
        )
    }


}