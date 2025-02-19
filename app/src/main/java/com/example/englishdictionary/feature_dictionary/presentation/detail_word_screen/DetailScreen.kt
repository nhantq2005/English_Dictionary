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
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import com.example.englishdictionary.feature_dictionary.presentation.components.AppBar
import com.example.englishdictionary.feature_dictionary.presentation.components.SaveButton
import com.example.englishdictionary.feature_dictionary.presentation.main_screen.components.MeaningItem
import com.example.englishdictionary.feature_dictionary.presentation.main_screen.components.PhoneticItem
import com.example.englishdictionary.ui.theme.AppTheme

@Composable
fun DetailScreen(){
    AppBar(topBar = {
        Row(
            modifier= Modifier
                .fillMaxWidth()
                .padding(25.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = "CANCEL",
                style = AppTheme.appTypograhy.word)
            SaveButton(size = 35.dp){

            }
        }
    }) {
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
        ){
//            state.wordItem?.let { wordItem ->
//                Column(
//                    modifier = Modifier
//                        .fillMaxSize()
//                        .padding(10.dp)
//                ) {
//                    Row(
//                        modifier = Modifier.fillMaxWidth(),
//                        verticalAlignment = Alignment.CenterVertically,
//                        horizontalArrangement = Arrangement.SpaceBetween
//                    ) {
//                        Text(
//                            text = wordItem.word,
//                            style = AppTheme.appTypograhy.word
//                        )
//                        SaveButton(size = 35.dp)
//                    }
//                    Spacer(modifier = Modifier.padding(vertical = 5.dp))
//                    //Show phonetic and pronunciation
//                    LazyRow(contentPadding = PaddingValues(vertical = 5.dp),
//                        verticalAlignment = Alignment.CenterVertically){
//                        items(wordItem.phonetics.size){index ->
//                            wordItem.phonetics[index].let {
//                                if (it != null) {
//                                    it.text?.let { it1 -> it.audio?.let { it2 -> PhoneticItem(phonetic = it1, url = it2) } }
//                                }
//                            }
//                        }
//                    }
//                    //Show meaning, example,... of word
//                    if(state.isLoading){
////                        Show circle proccess when load data
//                        CircularProgressIndicator(
//                            modifier = Modifier
//                                .size(80.dp),
//                            color = AppTheme.appColor.iconButton
//                        )
//                    }else {
//                        LazyColumn(contentPadding = PaddingValues(horizontal = 10.dp)) {
//                            items(wordItem.meanings.size) { index ->
//                                wordItem.meanings[index]?.let {
//                                    MeaningItem(
//                                        meaning = it,
//                                    )
//                                }
//                                Spacer(modifier = Modifier.height(5.dp))
//                            }
//                        }
//                    }
//                }
//            }
        }

    }
}

@Preview(showBackground = true)
@Composable
fun PreviewDetailScreen(){
    AppTheme {
        DetailScreen()
    }
}