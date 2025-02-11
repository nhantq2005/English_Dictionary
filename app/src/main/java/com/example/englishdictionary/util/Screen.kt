package com.example.englishdictionary.util

sealed class Screen(
    val route: String,
    val lable: String
) {
    object MainScreen:Screen("main_screen","Dictionary")
    object SavedWordScreen:Screen("saved_words_screen","Saved Words")
    object FlashCardScreen:Screen("flashcard_screen","Flashcard")
}