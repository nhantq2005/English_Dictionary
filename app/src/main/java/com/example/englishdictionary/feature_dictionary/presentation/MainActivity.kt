package com.example.englishdictionary.feature_dictionary.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.englishdictionary.feature_dictionary.presentation.flashcard_screen.FlashCardScreen
import com.example.englishdictionary.feature_dictionary.presentation.flashcard_screen.SlideLeftCardWithOffset
import com.example.englishdictionary.feature_dictionary.presentation.main_screen.MainScreen
import com.example.englishdictionary.feature_dictionary.presentation.saved_words_screen.SavedWordScreen
import com.example.englishdictionary.ui.theme.AppTheme
import com.example.englishdictionary.ui.theme.EnglishDictionaryTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppTheme {
//                SavedWordScreen()
                SavedWordScreen()
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    EnglishDictionaryTheme {
        Greeting("Android")
    }
}