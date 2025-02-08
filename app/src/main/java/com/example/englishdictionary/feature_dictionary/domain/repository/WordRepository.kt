//package com.example.englishdictionary.feature_dictionary.domain.repository
//
//import com.example.englishdictionary.feature_dictionary.domain.model.WordItem
//import kotlinx.coroutines.flow.Flow
//
//interface WordRepository {
//
//    fun getWords(): Flow<List<WordItem>>
//
//    suspend fun getWordById(id:Int):WordItem?
//
//    fun findWord(keyword:String):Flow<List<WordItem>>
//
//    suspend fun unsaveWord(wordItem: WordItem)
//
//    suspend fun saveWord(wordItem: WordItem)
//
//    suspend fun checkWordExists(word: String): Boolean
//}