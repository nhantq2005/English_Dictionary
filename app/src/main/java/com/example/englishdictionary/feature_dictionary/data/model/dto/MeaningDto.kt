package com.example.englishdictionary.feature_dictionary.data.model.dto

data class MeaningDto(
    val antonyms: List<String>?=null,
    val definitions: List<DefinitionDto>?=null,
    val partOfSpeech: String?=null,
    val synonyms: List<String>?=null
)