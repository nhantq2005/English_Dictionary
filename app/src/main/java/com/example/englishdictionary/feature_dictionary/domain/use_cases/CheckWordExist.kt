package com.example.englishdictionary.feature_dictionary.domain.use_cases

import com.example.englishdictionary.feature_dictionary.domain.repository.WordRepository

class CheckWordExist(
    private val wordRepository: WordRepository
) {
    suspend operator fun invoke(word:String):Boolean{
        return wordRepository.checkWordExists(word)
    }
}