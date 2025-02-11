package com.example.englishdictionary.feature_dictionary.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "words_table")
data class Word(
    @PrimaryKey(autoGenerate = true)
    val id:Int=0,
    val wordItem: WordItem,
    val timeStamp:Long
)