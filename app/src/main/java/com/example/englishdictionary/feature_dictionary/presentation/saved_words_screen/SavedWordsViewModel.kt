package com.example.englishdictionary.feature_dictionary.presentation.saved_words_screen

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.englishdictionary.feature_dictionary.domain.use_cases.WordUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class SavedWordsViewModel @Inject constructor(
    private val wordUseCases: WordUseCases
):ViewModel() {
    private val _savedWordState = mutableStateOf(SavedWordState())
    val savedWordSate:State<SavedWordState> = _savedWordState

    private var getSavedWordsJob: Job? = null

    init {
        getSavedWords()
    }

    fun onEvent(event: SavedWordEvent){
        when(event){
            is SavedWordEvent.EnteredKeyword -> {
                _savedWordState.value = savedWordSate.value.copy(
                    keyword = event.keyword
                )
            }
            is SavedWordEvent.FindWord -> {
                //Cancel get saved word
                getSavedWordsJob?.cancel()
                //Get word by search keyword
                getSavedWordsJob=wordUseCases.findWord(savedWordSate.value.keyword)
                    .onEach { words ->
                        _savedWordState.value = savedWordSate.value.copy(
                            savedWords = words
                        )
                    }.launchIn(viewModelScope)
            }
            is SavedWordEvent.UnsaveWord -> {
                viewModelScope.launch {
                    wordUseCases.unsaveWord(event.word)
                }
            }
        }
    }

    private fun getSavedWords(){
        getSavedWordsJob?.cancel()
        getSavedWordsJob = wordUseCases.getWords()
            .onEach { words ->
                _savedWordState.value = savedWordSate.value.copy(
                    savedWords = words
                )
            }.launchIn(viewModelScope)
    }

}