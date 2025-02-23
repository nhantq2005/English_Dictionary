package com.example.englishdictionary.di

import android.app.Application
import androidx.room.Room
import com.example.englishdictionary.feature_dictionary.data.data_source.WordDatabase
//import com.example.englishdictionary.feature_dictionary.data.data_source.WordDatabase
import com.example.englishdictionary.feature_dictionary.data.model.api.DictionaryApi
import com.example.englishdictionary.feature_dictionary.data.repository.WordRepositoryImpl
import com.example.englishdictionary.feature_dictionary.domain.repository.WordRepository
import com.example.englishdictionary.feature_dictionary.domain.use_cases.CheckWordExist
import com.example.englishdictionary.feature_dictionary.domain.use_cases.FindWord
import com.example.englishdictionary.feature_dictionary.domain.use_cases.GetWord
import com.example.englishdictionary.feature_dictionary.domain.use_cases.GetWords
import com.example.englishdictionary.feature_dictionary.domain.use_cases.SaveWord
import com.example.englishdictionary.feature_dictionary.domain.use_cases.UnsaveWord
import com.example.englishdictionary.feature_dictionary.domain.use_cases.WordUseCases
import com.example.englishdictionary.feature_dictionary.presentation.flashcard_screen.FlashcardViewModel
import com.example.englishdictionary.feature_dictionary.presentation.saved_words_screen.SavedWordState
//import com.example.englishdictionary.feature_dictionary.data.repository.WordRepositoryImpl
//import com.example.englishdictionary.feature_dictionary.domain.repository.WordRepository
//import com.example.englishdictionary.feature_dictionary.domain.use_cases.CheckWordExist
//import com.example.englishdictionary.feature_dictionary.domain.use_cases.FindWord
//import com.example.englishdictionary.feature_dictionary.domain.use_cases.GetWord
//import com.example.englishdictionary.feature_dictionary.domain.use_cases.GetWords
//import com.example.englishdictionary.feature_dictionary.domain.use_cases.SaveWord
//import com.example.englishdictionary.feature_dictionary.domain.use_cases.UnsaveWord
//import com.example.englishdictionary.feature_dictionary.domain.use_cases.WordUseCases
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    //Build room database
    @Provides
    @Singleton
    fun provideWordDatabase(app:Application): WordDatabase {
        return Room.databaseBuilder(
            app,
            WordDatabase::class.java,
            WordDatabase.DATABASE_NAME
        ).build()
    }

    private val interceptor: HttpLoggingInterceptor =
        HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }

    private val client: OkHttpClient = OkHttpClient.Builder()
        .addInterceptor(interceptor)
        .build()

    @Provides
    @Singleton
    fun providesDictionaryApi() : DictionaryApi {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(DictionaryApi.BASE_URL)
            .client(client)
            .build()
            .create()
    }

    @Provides
    @Singleton
    fun provideWordRepository(db:WordDatabase): WordRepository {
        return WordRepositoryImpl(db.wordDao)
    }

    @Provides
    @Singleton
    fun provideWordUseCases(wordRepository: WordRepository): WordUseCases {
        return WordUseCases(
            getWord = GetWord(wordRepository),
            getWords = GetWords(wordRepository),
            saveWord = SaveWord(wordRepository),
            unsaveWord = UnsaveWord(wordRepository),
            findWord = FindWord(wordRepository),
            checkWordExist = CheckWordExist(wordRepository)
        )
    }
}