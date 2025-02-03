package com.example.englishdictionary.feature_dictionary.data.model.dto

data class WordItemDto(
    val meanings: List<MeaningDto>?=null,
    val phonetics: List<PhoneticDto>?=null,
    val word: String?=null
)