package com.example.englishdictionary.feature_dictionary.presentation.main_screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
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
import kotlinx.coroutines.flow.update

@HiltViewModel
class MainViewModel @Inject constructor(
    private val wordUseCases: WordUseCases,
    private val dictionaryRepository: DictionaryRepository
) : ViewModel() {
    private val _state = MutableStateFlow(MainState())
    val state = _state.asStateFlow()

    private var currentWordResult: WordItem? = null

    private var searchJob: Job? = null

    init {
        _state.update {
            it.copy(searchWord = "hello")
        }

        searchJob?.cancel()
        searchJob = viewModelScope.launch {
            loadWordResult()
        }

        onEvent(MainEvent.CheckWordExist(state.value.searchWord))

    }

    fun onEvent(event: MainEvent) {
        when (event) {
            is MainEvent.EnteredWord -> {
                _state.value = state.value.copy(
                    searchWord = event.word
                )
            }

            MainEvent.OnSearchClick -> {
                searchJob?.cancel()
                searchJob = viewModelScope.launch {
                    loadWordResult()
                }
            }

            is MainEvent.SaveWord -> {
                viewModelScope.launch {
                    //Catch exception if do not have word
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
                    _state.value = state.value.copy(
                        isSavedWord = wordUseCases.checkWordExist(currentWordResult!!.word)
                    )
                }
            }

            is MainEvent.CheckWordExist -> {
                viewModelScope.launch {
                    _state.value = state.value.copy(
                        isSavedWord = wordUseCases.checkWordExist(event.word.lowercase())
                    )
                }
            }

            is MainEvent.UnsaveWord -> {
                viewModelScope.launch {
                    wordUseCases.unsaveWord(event.word)

                    _state.value = state.value.copy(
                        isSavedWord = wordUseCases.checkWordExist(event.word.word)
                    )
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
}