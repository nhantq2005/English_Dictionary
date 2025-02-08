//package com.example.englishdictionary.feature_dictionary.data.data_source
//
//import androidx.room.Dao
//import androidx.room.Delete
//import androidx.room.Insert
//import androidx.room.OnConflictStrategy
//import androidx.room.Query
//import com.example.englishdictionary.feature_dictionary.domain.model.WordItem
//import kotlinx.coroutines.flow.Flow
//
//@Dao
//interface WordDao {
//    @Query("SELECT * FROM words_table")
//    fun getWord(): Flow<List<WordItem>>
//
//    @Query("SELECT * FROM words_table WHERE id=:id")
//    suspend fun getWordById(id:Int):WordItem?
//
//    @Insert(onConflict = OnConflictStrategy.REPLACE)
//    fun addWord(wordItem: WordItem)
//
//    @Delete
//    fun deleteWord(wordItem: WordItem)
//
//    @Query("SELECT * FROM words_table WHERE word LIKE '%' || :keyword || '%'")
//    fun getWordByKeyword(keyword:String):Flow<List<WordItem>>
//
//    @Query("SELECT EXISTS(SELECT * FROM words_table WHERE word = :searchWord)")
//    fun isWordExists(searchWord: String): Boolean
//}