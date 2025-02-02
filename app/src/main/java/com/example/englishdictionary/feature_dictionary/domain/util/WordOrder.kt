package com.example.englishdictionary.feature_dictionary.domain.util

sealed class WordOrder {
    class Character():WordOrder()
    class Date():WordOrder()
}