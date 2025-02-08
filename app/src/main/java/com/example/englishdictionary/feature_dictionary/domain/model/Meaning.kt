package com.example.englishdictionary.feature_dictionary.domain.model

data class Meaning(
    val antonyms: List<String>?,
    val definitions: Definition?,
    val partOfSpeech: String?,
    val synonyms: List<String>?
)