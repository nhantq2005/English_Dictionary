package com.example.englishdictionary.feature_dictionary.presentation.flashcard_screen

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.outlined.Style
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.englishdictionary.feature_dictionary.presentation.components.AppBar
import com.example.englishdictionary.feature_dictionary.presentation.components.Warning
import com.example.englishdictionary.feature_dictionary.presentation.flashcard_screen.components.CountBox
import com.example.englishdictionary.feature_dictionary.presentation.flashcard_screen.components.FlashCard
import com.example.englishdictionary.feature_dictionary.presentation.flashcard_screen.components.ResultItem
import com.example.englishdictionary.feature_dictionary.presentation.saved_words_screen.SavedWordsViewModel
import com.example.englishdictionary.ui.theme.AppTheme
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun FlashCardScreen(
    navController: NavController,
    savedWordsViewModel: SavedWordsViewModel = hiltViewModel()

) {
//    Variable for animation of flashcard
    var visible by remember { mutableStateOf(true) }
    val scope = rememberCoroutineScope()
    val configuration = LocalConfiguration.current
    var screenWidthDp = configuration.screenWidthDp
//    State to get list saved word
    val savedWordsState = savedWordsViewModel.savedWordSate.value
//    Value count remember and forget word
    var countRightWord by rememberSaveable { mutableIntStateOf(0) }
    var countWrongWord by rememberSaveable { mutableIntStateOf(0) }
//    Index of wordItem in list
    var index = 0
    AppBar(
        topBar = {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(15.dp)
            ) {
                Icon(
                    Icons.Outlined.Style,
                    contentDescription = "Flashcard Icon",
                    modifier = Modifier.size(50.dp)
                )
                Spacer(modifier = Modifier.padding(horizontal = 3.dp))
                Text(
                    text = "Flashcards",
                    style = AppTheme.appTypograhy.title
                )
            }
        },
        containerColor = AppTheme.appColor.background,
        navController = navController
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(AppTheme.appColor.background),
            contentAlignment = Alignment.Center
        ) {
            if (savedWordsState.savedWords.isEmpty()) {
//                Warning if saved word is empty
                Warning()
            } else if (index == savedWordsState.savedWords.size) {
                ResultItem(countRightWord = countRightWord, countWrongWord = countWrongWord)
            } else {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.SpaceAround
                ) {
//                    Count remember and forget word
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        CountBox(countValue = countWrongWord, color = AppTheme.appColor.wrong)
                        CountBox(countValue = countRightWord, color = AppTheme.appColor.right)
                    }
                    Spacer(modifier = Modifier.padding(vertical = 5.dp))
                    Box(modifier = Modifier.fillMaxHeight(0.8f)) {
//                        flip animation
                        this@Column.AnimatedVisibility(
                            visible = visible,
                            enter = fadeIn(),
                            exit = slideOutHorizontally { screenWidthDp } + fadeOut(),
                            modifier = Modifier.fillMaxHeight()
                        ) {
                            FlashCard(savedWordsState.savedWords[index])
                        }
                    }
                    Spacer(modifier = Modifier.padding(vertical = 10.dp))
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceEvenly,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
//                        Forget word button
                        Icon(
                            imageVector = Icons.Default.Close,
                            contentDescription = "Forget word button",
                            tint = AppTheme.appColor.wrong,
                            modifier = Modifier
                                .size(height = 65.dp, width = 100.dp)
                                .shadow(5.dp, RoundedCornerShape(15.dp))
                                .background(Color.White, RoundedCornerShape(15.dp))
                                .clickable {
                                    index++
                                    countWrongWord++
                                    scope.launch {
//                                        Negative value -> Animation to left
                                        screenWidthDp = -screenWidthDp
                                        visible = !visible
                                        delay(800)
                                        visible = !visible
//                                        Reset value
                                        screenWidthDp = -screenWidthDp
                                    }
                                }
                        )
//                        Remember word button
                        Icon(
                            imageVector = Icons.Default.Check,
                            contentDescription = "Remember word button",
                            tint = AppTheme.appColor.right,
                            modifier = Modifier
                                .size(height = 65.dp, width = 100.dp)
                                .shadow(5.dp, RoundedCornerShape(15.dp))
                                .background(Color.White, RoundedCornerShape(15.dp))
                                .clickable {
                                    index++
                                    countRightWord++
                                    scope.launch {
                                        visible = !visible
                                        delay(800)
                                        visible = !visible
                                    }
                                }
                        )
                    }
                }
            }
        }
    }
}
