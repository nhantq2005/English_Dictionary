package com.example.englishdictionary.feature_dictionary.domain.use_cases

import com.example.englishdictionary.feature_dictionary.domain.model.WordItem
import com.example.englishdictionary.feature_dictionary.domain.repository.WordRepository

class GetWord(
    private val wordRepository: WordRepository
) {
    suspend operator fun invoke(id:Int):WordItem?{
        return wordRepository.getWordById(id)
    }
}