package com.example.englishdictionary.feature_dictionary.data.data_source


import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.englishdictionary.feature_dictionary.domain.model.WordItem
import com.example.englishdictionary.feature_dictionary.domain.util.Converters


@Database(
    entities = [WordItem::class],
    version = 1
)
@TypeConverters(Converters::class)
abstract class WordDatabase:RoomDatabase() {
    abstract val wordDao:WordDao

    companion object{
        const val DATABASE_NAME = "word_db"
    }
}