package com.example.englishdictionary.feature_dictionary.domain.util

import androidx.room.TypeConverter
import com.example.englishdictionary.feature_dictionary.domain.model.Definition
import com.example.englishdictionary.feature_dictionary.domain.model.Meaning
import com.example.englishdictionary.feature_dictionary.domain.model.Phonetic
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken


//Convert nested object to save in Roomdatabase
class Converters {
//    private val gson = Gson()

//    private val gson = Gson()
//
//    @TypeConverter
//    fun fromMeaning(meaing:List<Meaning>):String{
//        return gson.toJson(meaing)
//    }
//
//    @TypeConverter
//    fun toMeaning(meaningString:String):List<Meaning>{
//        val type = object : TypeToken<List<Meaning>>(){}.type
//        return gson.fromJson(meaningString,type)
//    }
//
//    @TypeConverter
//    fun fromPhonetic(phonetic: List<Phonetic>):String{
//        return gson.toJson(phonetic)
//    }
//
//    @TypeConverter
//    fun toPhonetic(phoneticString: String):List<Phonetic>{
//        val type = object : TypeToken<List<Meaning>>(){}.type
//        return gson.fromJson(phoneticString,type)
//    }
//
//    @TypeConverter
//    fun fromDefinition(definition: Definition):String{
//        return gson.toJson(definition)
//    }
//
//    @TypeConverter
//    fun toDefinition(definitionString: String):Definition{
//        val type = object : TypeToken<List<Meaning>>(){}.type
//        return gson.fromJson(definitionString,type)
//    }

    private val gson = Gson()

    @TypeConverter
    fun fromPhoneticList(value: List<Phonetic>): String = gson.toJson(value)

    @TypeConverter
    fun toPhoneticList(value: String): List<Phonetic> {
        val type = object : TypeToken<List<Phonetic>>() {}.type
        return gson.fromJson(value, type)
    }

    @TypeConverter
    fun fromMeaningList(value: List<Meaning>): String = gson.toJson(value)

    @TypeConverter
    fun toMeaningList(value: String): List<Meaning> {
        val type = object : TypeToken<List<Meaning>>() {}.type
        return gson.fromJson(value, type)
    }

    @TypeConverter
    fun fromDefinition(value: Definition): String = gson.toJson(value)

    @TypeConverter
    fun toDefinition(value: String): Definition {
        val type = object : TypeToken<Definition>() {}.type
        return gson.fromJson(value, type)
    }
}