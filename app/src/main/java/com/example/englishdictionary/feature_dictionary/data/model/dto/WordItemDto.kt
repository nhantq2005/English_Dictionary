package com.example.englishdictionary.feature_dictionary.data.model.dto

data class WordItemDto(
    val meanings: List<MeaningDto>,
    val phonetics: List<PhoneticDto>,
    val word: String
)