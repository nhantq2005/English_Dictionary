package com.example.englishdictionary.feature_dictionary.presentation.flashcard_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.BookmarkBorder
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.LibraryAddCheck
import androidx.compose.material.icons.filled.Note
import androidx.compose.material.icons.filled.NoteAdd
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MediumTopAppBar
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.englishdictionary.feature_dictionary.presentation.flashcard_screen.components.FlashCard
import com.example.englishdictionary.ui.theme.EnglishDictionaryTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FlashCardScreen() {
    Scaffold(
        topBar = {
            TopAppBar(title = {
                Row {
                    Icon(Icons.Default.NoteAdd, contentDescription = "Flashcard icon")
                    Text(text = "FlashCard")
                }

            })
        },
        bottomBar = {
            NavigationBar {
                Row(
                    modifier = Modifier.fillMaxSize(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    Icon(Icons.Default.Search, contentDescription = "Look up word")
                    Icon(Icons.Default.BookmarkBorder, contentDescription = "Look up word")
                    Icon(Icons.Default.Edit,contentDescription = null)

                }
            }
        }
    ) { paddingValues ->
        Box(
            modifier = Modifier
                .padding(paddingValues)
                .background(Color.Blue, shape = RoundedCornerShape(15.dp))
                .fillMaxSize()
                .padding(15.dp),
            contentAlignment = Alignment.Center
        ) {
            FlashCard()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewFlashCardScreen() {
    EnglishDictionaryTheme {
        FlashCardScreen()
    }
}