package com.example.englishdictionary.feature_dictionary.presentation.main_screen

import android.util.Log
import androidx.compose.runtime.State
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.englishdictionary.feature_dictionary.domain.model.Definition
import com.example.englishdictionary.feature_dictionary.domain.model.Meaning
import com.example.englishdictionary.feature_dictionary.domain.model.Phonetic
import com.example.englishdictionary.feature_dictionary.domain.model.WordItem
import com.example.englishdictionary.feature_dictionary.domain.repository.DictionaryRepository
import com.example.englishdictionary.feature_dictionary.domain.use_cases.WordUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject
import com.example.englishdictionary.util.Result
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.update

@HiltViewModel
class MainScreenViewModel @Inject constructor(
    private val wordUseCases: WordUseCases,
    private val dictionaryRepository: DictionaryRepository
) : ViewModel() {
    private val _state = MutableStateFlow(MainState())
    val state = _state.asStateFlow()


    private var currentWordResult: WordItem?=null
//    = WordItem(
//        word = "WIN",
//        phonetics = listOf(
//            Phonetic(
//                audio = "1230",
//                text = "498"
//            )
//        ),
//        meanings = listOf(
//            Meaning(
//                partOfSpeech = "A",
//                definitions = Definition(definition = "1", example = "1"),
//                antonyms = listOf("1","8"),
//                synonyms = listOf("1","8")
//            )
//
//        ),
//        timeStamp = 0
//    )

    private var searchJob: Job? = null

    init {
        _state.update {
            it.copy(searchWord = "hello")
        }

        searchJob?.cancel()
        searchJob = viewModelScope.launch {
            loadWordResult()
        }
    }

    fun onEvent(event: MainEvent) {
        when (event) {
            is MainEvent.enteredWord -> {
                _state.value = state.value.copy(
                    searchWord = event.word
                )
            }

            MainEvent.onSearchClick -> {
                searchJob?.cancel()
                searchJob = viewModelScope.launch {
                    loadWordResult()
                }
            }

            is MainEvent.saveWord -> {
                viewModelScope.launch {
//currentWordResult?.let { Log.e("SHOW DATA", it.word) }
                    try {
                        currentWordResult?.let {
                            WordItem(
                                timeStamp = System.currentTimeMillis(),
                                word = it.word,
                                phonetics = currentWordResult!!.phonetics,
                                meanings = currentWordResult!!.meanings
                            )
                        }?.let {
                            wordUseCases.saveWord(
                                it
                            )
                        }

                    } catch (_: Exception) {

                    }
                }
            }
        }
    }

    private fun loadWordResult() {
        viewModelScope.launch {
            dictionaryRepository.getWordResult(
                state.value.searchWord
            ).collect { result ->
                when (result) {
                    is Result.Error -> Unit
                    is Result.Loading -> {
                        _state.update {
                            it.copy(isLoading = result.isLoading)
                        }
                    }

                    is Result.Success -> {
                        result.data?.let { wordItem ->
                            _state.update {
                                it.copy(
                                    wordItem = wordItem
                                )
                            }
                            currentWordResult = wordItem
                        }
                    }
                }
            }
        }
    }

    sealed class UiEvent {
        object SaveWord : UiEvent()
    }
}