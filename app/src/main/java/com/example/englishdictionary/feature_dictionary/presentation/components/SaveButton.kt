package com.example.englishdictionary.feature_dictionary.presentation.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Bookmark
import androidx.compose.material.icons.filled.BookmarkBorder
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.tooling.preview.Preview
import com.example.englishdictionary.ui.theme.EnglishDictionaryTheme

@Composable
fun SaveButton(){
    var saveButtonState by remember {
        mutableStateOf(false)
    }
    IconButton(onClick = { saveButtonState=!saveButtonState }) {
        Icon(
            if (saveButtonState){
                Icons.Default.Bookmark
            }else{
                Icons.Default.BookmarkBorder
            }
            , contentDescription = "Save word button")
    }
}

@Preview(showBackground = true)
@Composable
fun ReviewSaveButton(){
    EnglishDictionaryTheme {
        SaveButton()
    }
}