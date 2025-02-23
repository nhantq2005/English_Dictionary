package com.example.englishdictionary.feature_dictionary.presentation.components

import androidx.compose.foundation.layout.size
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
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.englishdictionary.ui.theme.EnglishDictionaryTheme

@Composable
fun SaveButton(
    size:Dp,
    isSaved:Boolean,
    onClick:()->Unit
) {
    var saveButtonState by remember {
        mutableStateOf(false)
    }
    IconButton(onClick = {
        saveButtonState = !saveButtonState
        onClick()
    }) {
        if (isSaved) {
            Icon(
                Icons.Default.Bookmark,
                contentDescription = "Save icon",
                tint = Color(0xFFF1EA20),
                modifier = Modifier.size(size)
            )
        } else {
            Icon(
                Icons.Default.BookmarkBorder,
                contentDescription = "Unsave icon",
                modifier = Modifier.size(size)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ReviewSaveButton() {
    EnglishDictionaryTheme {
//        SaveButton(20.dp)
    }
}