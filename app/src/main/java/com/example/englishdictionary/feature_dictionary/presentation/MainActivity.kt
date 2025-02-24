package com.example.englishdictionary.feature_dictionary.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.englishdictionary.feature_dictionary.presentation.detail_word_screen.DetailScreen
import com.example.englishdictionary.feature_dictionary.presentation.flashcard_screen.FlashCardScreen
import com.example.englishdictionary.feature_dictionary.presentation.main_screen.MainScreen
import com.example.englishdictionary.feature_dictionary.presentation.saved_words_screen.SavedWordScreen
import com.example.englishdictionary.ui.theme.AppTheme
import com.example.englishdictionary.ui.theme.EnglishDictionaryTheme
import com.example.englishdictionary.util.Screen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppTheme {
                val navController = rememberNavController()
                NavHost(navController = navController, startDestination = Screen.MainScreen.route) {
                    composable(Screen.MainScreen.route) {
                        MainScreen(navController = navController)
                    }

                    composable(Screen.SavedWordScreen.route) {
                        SavedWordScreen(navController = navController)
                    }

                    composable(Screen.DetailScreen.route + "?wordId={wordId}",
                        arguments = listOf(
                            navArgument(name = "wordId") {
                                type = NavType.IntType
                                defaultValue = -1
                            }
                        )) {
                        DetailScreen(navController = navController)
                    }
                    
                    composable(Screen.FlashCardScreen.route){
                        FlashCardScreen(navController = navController)
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    EnglishDictionaryTheme {
    }
}