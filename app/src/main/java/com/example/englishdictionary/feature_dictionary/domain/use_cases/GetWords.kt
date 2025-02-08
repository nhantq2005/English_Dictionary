//package com.example.englishdictionary.feature_dictionary.domain.use_cases
//
//import com.example.englishdictionary.feature_dictionary.domain.model.WordItem
//import com.example.englishdictionary.feature_dictionary.domain.repository.WordRepository
//import kotlinx.coroutines.flow.Flow
//import kotlinx.coroutines.flow.map
//
//class GetWords(
//    private val wordRepository: WordRepository
//) {
//    operator fun invoke(): Flow<List<WordItem>>{
//        return wordRepository.getWords().map { word ->
//            word.sortedBy { it.timeStamp }
//        }
//    }
//}