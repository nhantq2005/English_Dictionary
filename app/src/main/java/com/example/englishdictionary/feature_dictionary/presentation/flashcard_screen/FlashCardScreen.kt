package com.example.englishdictionary.feature_dictionary.presentation.flashcard_screen

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideOutHorizontally
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
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.englishdictionary.feature_dictionary.presentation.components.AppBar
import com.example.englishdictionary.feature_dictionary.presentation.flashcard_screen.components.FlashCard
import com.example.englishdictionary.ui.theme.AppTheme
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun FlashCardScreen() {
    var visible by remember { mutableStateOf(true) }
    val scope = rememberCoroutineScope()
    val configuration = LocalConfiguration.current
    var screenWidthDp = configuration.screenWidthDp
    AppBar(topBar = {
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
    }) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceEvenly
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = "1",
                        modifier = Modifier.padding(vertical = 30.dp, horizontal = 10.dp)
                    )
                    Text(
                        text = "1",
                        modifier = Modifier.padding(vertical = 30.dp, horizontal = 10.dp)
                    )
                }
                this@Column.AnimatedVisibility(
                    visible = visible,
                    enter = fadeIn(),
                    exit = slideOutHorizontally { screenWidthDp } + fadeOut()
                ) {
                    FlashCard()
                }
                Spacer(modifier = Modifier.padding(vertical = 30.dp))
                Row(
                    modifier = Modifier.fillMaxSize(),
                    horizontalArrangement = Arrangement.SpaceAround,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    IconButton(onClick = {
                        scope.launch {
                            screenWidthDp = -screenWidthDp
                            visible = !visible
                            delay(800)
                            visible = !visible
                        }
                    },
                        modifier = Modifier.padding(25.dp)
                            .shadow(7.dp, shape = RoundedCornerShape(10.dp))
                    ) {
                        Icon(
                            Icons.Default.Close,
                            contentDescription = null,
                            modifier = Modifier.size(40.dp),
                            tint = AppTheme.appColor.wrong
                        )
                    }
                    IconButton(onClick = {
                        scope.launch {
                            visible = !visible
                            delay(800)
                            visible = !visible
                        }
                    }) {
                        Icon(
                            Icons.Default.Check,
                            contentDescription = null,
                            modifier = Modifier.size(40.dp),
                            tint = AppTheme.appColor.right
                        )
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewFlashCardScreen() {
    AppTheme {
        FlashCardScreen()
    }
}