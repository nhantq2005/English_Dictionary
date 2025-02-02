package com.example.englishdictionary.feature_dictionary.domain.repository

import com.example.englishdictionary.feature_dictionary.domain.model.WordItem
import com.example.englishdictionary.util.Result
import kotlinx.coroutines.flow.Flow


interface DictionaryRepository {
    suspend fun getWordResult(
        word:String
    ): Flow<Result<WordItem>>
}