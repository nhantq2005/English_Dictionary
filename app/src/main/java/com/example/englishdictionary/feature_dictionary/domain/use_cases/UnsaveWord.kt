package com.example.englishdictionary.feature_dictionary.domain.use_cases

import com.example.englishdictionary.feature_dictionary.domain.model.WordItem
import com.example.englishdictionary.feature_dictionary.domain.repository.WordRepository

class UnsaveWord(
    private val wordRepository: WordRepository
) {
    suspend operator fun invoke(wordItem: WordItem){
        return wordRepository.unsaveWord(wordItem)
    }
}