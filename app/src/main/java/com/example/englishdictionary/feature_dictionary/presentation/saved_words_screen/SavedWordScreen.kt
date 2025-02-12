package com.example.englishdictionary.feature_dictionary.presentation.saved_words_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Bookmark
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import com.example.englishdictionary.feature_dictionary.presentation.components.AppBar
import com.example.englishdictionary.feature_dictionary.presentation.saved_words_screen.components.SavedWordItem
import com.example.englishdictionary.ui.theme.AppTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SavedWordScreen() {
    AppBar(
        topBar = {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    Icons.Default.Bookmark,
                    contentDescription = "Saved word",
                    modifier = Modifier.size(60.dp)
                )
                Spacer(modifier = Modifier.width(2.dp))
                Text(
                    text = "Saved\nWord",
                    style = AppTheme.appTypograhy.title.copy(fontSize = 30.sp)
                )
            }
        }

    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .shadow(15.dp)
                .background(
                    AppTheme.appColor.flashcard,
                    shape = RoundedCornerShape(topEnd = 15.dp, topStart = 15.dp)
                )
                .padding(top = 15.dp)
                .zIndex(-1f)
        ) {
            Column(Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally) {
                TextField(
                    value = "",
                    onValueChange = {},
                    modifier = Modifier.fillMaxWidth(0.95f)
                        .shadow(elevation = 7.dp, shape = RoundedCornerShape(18.dp)),
                    colors = TextFieldDefaults.textFieldColors(
                        containerColor = AppTheme.appColor.textField,
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent,
                        cursorColor = AppTheme.appColor.navIcon
                    ),
                    placeholder = {
                        Text(text = "Word",
                            style = AppTheme.appTypograhy.placeholder
                        )},
                    trailingIcon = {
                        Icon(Icons.Default.Search,
                            contentDescription = "Search Icon"
                        )},
                    shape = RoundedCornerShape(18.dp),
                )
                Spacer(modifier = Modifier.height(8.dp))
                SavedWordItem()
            }

        }

    }
}