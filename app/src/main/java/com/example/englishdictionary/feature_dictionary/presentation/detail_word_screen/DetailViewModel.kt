package com.example.englishdictionary.feature_dictionary.presentation.detail_word_screen


import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.englishdictionary.feature_dictionary.domain.repository.DictionaryRepository
import com.example.englishdictionary.feature_dictionary.domain.use_cases.WordUseCases
import com.example.englishdictionary.feature_dictionary.presentation.main_screen.MainEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val wordUseCases: WordUseCases,
    savedStateHandle: SavedStateHandle
) : ViewModel() {
    private val _detailSate = mutableStateOf(DetailState())
    val detailState: State<DetailState> = _detailSate

    init {
        savedStateHandle.get<Int>("wordId")?.let { wordId ->
            if (wordId != -1) {
                viewModelScope.launch {
                    wordUseCases.getWord(wordId)?.also {
                        _detailSate.value = detailState.value.copy(
                            wordItem = it
                        )
                    }
                }
            }
        }

        detailState.value.wordItem?.let { DetailEvent.CheckWordExist(it.word) }?.let { onEvent(it) }
    }

    fun onEvent(event: DetailEvent) {
        when (event) {
            is DetailEvent.SaveWord -> {
                viewModelScope.launch {
                    wordUseCases.saveWord(event.wordItem)
//                    Update word saved state
                    _detailSate.value = detailState.value.copy(
                        isSavedWord = wordUseCases.checkWordExist(event.wordItem.word.lowercase())
                    )
                }
            }

            is DetailEvent.UnsaveWord -> {
                viewModelScope.launch {
                    wordUseCases.unsaveWord(event.wordItem)
//                    Update word saved state
                    _detailSate.value = detailState.value.copy(
                        isSavedWord = wordUseCases.checkWordExist(event.wordItem.word.lowercase())
                    )
                }
            }

            is DetailEvent.CheckWordExist -> {
                viewModelScope.launch {
                    _detailSate.value = detailState.value.copy(
                        isSavedWord = wordUseCases.checkWordExist(event.word.lowercase())
                    )
                }
            }
        }
    }
}