//package com.example.englishdictionary.feature_dictionary.domain.util
//
//import androidx.room.TypeConverter
//import com.example.englishdictionary.feature_dictionary.domain.model.Definition
//import com.example.englishdictionary.feature_dictionary.domain.model.Meaning
//import com.example.englishdictionary.feature_dictionary.domain.model.Phonetic
//import com.google.gson.Gson
//import kotlinx.serialization.decodeFromString
//import kotlinx.serialization.encodeToString
//import kotlinx.serialization.json.Json
//import kotlinx.serialization.json.Json.Default.encodeToString
//
////Convert nested object to save in Roomdatabase
//class Converters {
////    private val gson = Gson()
//
//    private val json = Json {
//        ignoreUnknownKeys = true
//        encodeDefaults = true
//    }
//
//    @TypeConverter
//    fun fromMeaning(meaing:List<Meaning>):String{
//        return json.encodeToString(meaing)
//    }
//
//    @TypeConverter
//    fun toMeaning(meaningString:String):List<Meaning>{
//        return json.decodeFromString(meaningString)
//    }
//
//    @TypeConverter
//    fun fromPhonetic(phonetic: List<Phonetic>):String{
//        return json.encodeToString(phonetic)
//    }
//
//    @TypeConverter
//    fun toPhonetic(phoneticString: String):List<Phonetic>{
//        return json.decodeFromString(phoneticString)
//    }
//
//    @TypeConverter
//    fun fromDefinition(definition: Definition):String{
//        return json.encodeToString(definition)
//    }
//
//    @TypeConverter
//    fun toDefinition(definitionString: String):Definition{
//        return json.decodeFromString(definitionString)
//    }
//}