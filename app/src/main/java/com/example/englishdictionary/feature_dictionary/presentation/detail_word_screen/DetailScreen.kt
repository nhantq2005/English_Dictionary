package com.example.englishdictionary.feature_dictionary.presentation.detail_word_screen

import androidx.compose.foundation.background
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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.englishdictionary.feature_dictionary.presentation.components.AppBar
import com.example.englishdictionary.feature_dictionary.presentation.components.SaveButton
import com.example.englishdictionary.feature_dictionary.presentation.main_screen.components.MeaningItem
import com.example.englishdictionary.feature_dictionary.presentation.main_screen.components.PhoneticItem
import com.example.englishdictionary.ui.theme.AppTheme

@Composable
fun DetailScreen(
    viewModel: DetailViewModel = hiltViewModel(),
    navController: NavController
) {

    val detailState = viewModel.detailState.value

    AppBar(topBar = {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(25.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            detailState.wordItem?.let {
                Text(
                    text = it.word,
                    style = AppTheme.appTypograhy.word.copy(fontSize=45.sp)
                )
            }
            SaveButton(size = 35.dp,isSaved = detailState.isSavedWord) {
                if (detailState.isSavedWord) {
                    detailState.wordItem?.let { DetailEvent.UnsaveWord(it) }?.let {
                        viewModel.onEvent(
                            it
                        )
                    }
                } else {
                    detailState.wordItem?.let { DetailEvent.SaveWord(it) }?.let {
                        viewModel.onEvent(
                            it
                        )
                    }
                }
            }
        }
    },
        containerColor = AppTheme.appColor.header,
        navController = navController
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
            detailState.wordItem.let { wordItem ->
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(10.dp)
                ) {
                    Spacer(modifier = Modifier.padding(vertical = 5.dp))
                    //Show phonetic and pronunciation
                    LazyRow(
                        contentPadding = PaddingValues(vertical = 5.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        if (wordItem != null) {
                            items(wordItem.phonetics.size) { index ->
                                wordItem.phonetics[index].let {
                                    it.text?.let { it1 ->
                                        it.audio?.let { it2 ->
                                            PhoneticItem(
                                                phonetic = it1,
                                                url = it2
                                            )
                                        }
                                    }
                                }
                            }
                        }
                    }
                    Spacer(modifier = Modifier.padding(5.dp))
                    //Show meaning, example,... of word
                    LazyColumn(contentPadding = PaddingValues(horizontal = 10.dp)) {
                        if (wordItem != null) {
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