package com.example.englishdictionary.feature_dictionary.presentation.main_screen

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.englishdictionary.feature_dictionary.presentation.components.AppBar
import com.example.englishdictionary.feature_dictionary.presentation.components.SaveButton
import com.example.englishdictionary.feature_dictionary.presentation.main_screen.components.MeaningItem
import com.example.englishdictionary.feature_dictionary.presentation.main_screen.components.PhoneticItem
import com.example.englishdictionary.ui.theme.AppTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen() {
    val mainViewModel = hiltViewModel<MainScreenViewModel>()
    val state by mainViewModel.state.collectAsState()

    AppBar(topBar = {
        CenterAlignedTopAppBar(title = {
            TextField(
                value = state.searchWord,
                onValueChange = {
                    mainViewModel.onEvent(
                        MainEvent.enteredWord(it)
                    )
                },
                maxLines = 1,
                modifier = Modifier
                    .fillMaxWidth()
                    .shadow(elevation = 7.dp, shape = RoundedCornerShape(18.dp)),
                colors = TextFieldDefaults.textFieldColors(
                    containerColor = AppTheme.appColor.textField,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    cursorColor = AppTheme.appColor.navIcon
                ),
                placeholder = {
                    Text(
                        text = "Word",
                        style = AppTheme.appTypograhy.placeholder
                    )
                },
                trailingIcon = {
                    Icon(
                        Icons.Default.Search,
                        contentDescription = "Search Icon",
                        modifier = Modifier.clickable {
                            mainViewModel.onEvent(
                                MainEvent.onSearchClick
                            )
                        }
                    )
                },
                shape = RoundedCornerShape(18.dp),
            )
        },
            modifier = Modifier.padding(vertical = 20.dp))
    }
    ) {

        Box(
            modifier = Modifier
                .fillMaxSize()
                .shadow(15.dp)
                .background(
                    AppTheme.appColor.background,
                    shape = RoundedCornerShape(topEnd = 15.dp, topStart = 15.dp)
                )
                .zIndex(-1f),
            contentAlignment = Alignment.Center
        ) {
            state.wordItem?.let { wordItem ->
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(10.dp),
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(
                            text = wordItem.word,
                            style = AppTheme.appTypograhy.word
                        )
                        SaveButton(size = 35.dp){
                            mainViewModel.onEvent(
                                MainEvent.saveWord(wordItem)
                            )
//                            Log.e("SHOW","it.word screen")
                        }
                    }
                    Spacer(modifier = Modifier.padding(vertical = 5.dp))
                    //Show phonetic and pronunciation
                    LazyRow(contentPadding = PaddingValues(vertical = 5.dp),
                        verticalAlignment = Alignment.CenterVertically){
                        items(wordItem.phonetics.size){index ->
                            wordItem.phonetics[index].let {
                                it.text?.let { it1 -> it.audio?.let { it2 -> PhoneticItem(phonetic = it1, url = it2) } }
                            }
                        }
                    }
                    //Show meaning, example,... of word
                    if(state.isLoading){
//                        Show circle proccess when load data
                        Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center){
                            CircularProgressIndicator(
                                modifier = Modifier
                                    .size(80.dp),
                                color = AppTheme.appColor.iconButton
                            )
                        }

                    }else {
                        LazyColumn(contentPadding = PaddingValues(horizontal = 10.dp)) {
                            items(wordItem.meanings.size) { index ->
                                MeaningItem(
                                    meaning = wordItem.meanings[index],
                                )
                                Spacer(modifier = Modifier.height(5.dp))
                            }
                        }
                    }
                }
            }
        }
    }
}

//@Preview(showBackground = true)
//@Composable
//fun PreviewMainScreen() {
//    AppTheme {
//        MainScreen()
//    }
//}