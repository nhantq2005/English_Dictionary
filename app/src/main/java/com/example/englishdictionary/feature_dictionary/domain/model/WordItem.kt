package com.example.englishdictionary.feature_dictionary.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "words_table")
data class WordItem(
    @PrimaryKey(autoGenerate = true)
    val id:Int=0,
    val meanings: List<Meaning?>,
    val phonetics: List<Phonetic?>,
    val word: String,
    val timeStamp:Long
)