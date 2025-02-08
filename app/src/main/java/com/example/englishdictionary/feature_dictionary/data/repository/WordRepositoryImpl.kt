//package com.example.englishdictionary.feature_dictionary.data.repository
//
//import com.example.englishdictionary.feature_dictionary.data.data_source.WordDao
//import com.example.englishdictionary.feature_dictionary.domain.model.WordItem
//import com.example.englishdictionary.feature_dictionary.domain.repository.WordRepository
//import kotlinx.coroutines.flow.Flow
//
//class WordRepositoryImpl(
//    private val dao: WordDao
//) : WordRepository {
//    override fun getWords(): Flow<List<WordItem>> {
//        return dao.getWord()
//    }
//
//    override suspend fun getWordById(id: Int): WordItem? {
//        return dao.getWordById(id)
//    }
//
//    override fun findWord(keyword: String): Flow<List<WordItem>> {
//        return dao.getWordByKeyword(keyword)
//    }
//
//    override suspend fun unsaveWord(wordItem: WordItem) {
//        return dao.deleteWord(wordItem)
//    }
//
//    override suspend fun saveWord(wordItem: WordItem) {
//        return dao.addWord(wordItem)
//    }
//
//    override suspend fun checkWordExists(word: String): Boolean {
//        return dao.isWordExists(word)
//    }
//
//}