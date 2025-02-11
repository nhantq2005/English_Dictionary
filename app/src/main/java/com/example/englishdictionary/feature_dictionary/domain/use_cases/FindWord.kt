package com.example.englishdictionary.feature_dictionary.domain.use_cases

import com.example.englishdictionary.feature_dictionary.domain.model.WordItem
import com.example.englishdictionary.feature_dictionary.domain.repository.WordRepository
import kotlinx.coroutines.flow.Flow

class FindWord(
    private val wordRepository: WordRepository
) {
    operator fun invoke(keyword:String):Flow<List<WordItem>>{
        return wordRepository.findWord(keyword)
    }
}