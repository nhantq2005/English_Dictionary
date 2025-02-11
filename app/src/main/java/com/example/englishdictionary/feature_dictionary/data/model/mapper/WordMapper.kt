package com.example.englishdictionary.feature_dictionary.data.model.mapper

import com.example.englishdictionary.feature_dictionary.data.model.dto.DefinitionDto
import com.example.englishdictionary.feature_dictionary.data.model.dto.MeaningDto
import com.example.englishdictionary.feature_dictionary.data.model.dto.PhoneticDto
import com.example.englishdictionary.feature_dictionary.data.model.dto.WordItemDto
import com.example.englishdictionary.feature_dictionary.data.model.dto.WordResultDto
import com.example.englishdictionary.feature_dictionary.domain.model.Definition
import com.example.englishdictionary.feature_dictionary.domain.model.Meaning
import com.example.englishdictionary.feature_dictionary.domain.model.Phonetic
import com.example.englishdictionary.feature_dictionary.domain.model.WordItem

//Convert Dto to Object

fun WordItemDto.toWordItem() = WordItem(
    word = word ?:"",
    meanings = meanings?.map {
        it.toMeaning()
    }?: emptyList(),
    phonetics = phonetics?.map {
        it.toPhonetic()
    }?: emptyList(),
    timeStamp =System.currentTimeMillis()
)

fun MeaningDto.toMeaning() = Meaning(
    definitions = definitionDtoToDefinition(definitions?.get(0)),
    partOfSpeech = partOfSpeech?:"",
    synonyms = synonyms,
    antonyms = antonyms
)

fun PhoneticDto.toPhonetic() = Phonetic(
    audio = audio,
    text = text
)

fun definitionDtoToDefinition(
    definitionDto: DefinitionDto?
)=Definition(
    definition = definitionDto?.definition?:"",
    example = definitionDto?.example?:""
)