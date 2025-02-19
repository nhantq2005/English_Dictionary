package com.example.englishdictionary.feature_dictionary.presentation.flashcard_screen

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.delay

@Composable
fun SlideLeftCardWithOffset() {
    var visible by remember { mutableStateOf(true) }
//    var scope = CoroutineScope(Dispatchers.IO)

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        AnimatedVisibility(
            visible = visible,
            enter = fadeIn(),
            exit = slideOutHorizontally { it } + fadeOut()
        ) {
                Card(
                    modifier = Modifier
                        .size(200.dp, 100.dp),
                    colors = CardDefaults.cardColors(containerColor = Color.Blue)
                ) {
                    Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxSize()) {
                        Text(text = "Swipe Left", color = Color.White, fontSize = 18.sp)
                    }
                }
            }




        Spacer(modifier = Modifier.height(20.dp))

        Button(onClick = {
//            scope.launch {
//            visible=!visible
//            delay(800)
//            visible=!visible
//        }
            visible=!visible
        }) {
            Text(if (visible) "Ẩn" else "Hiện")
        }
    }

    LaunchedEffect(Unit) {
        delay(200) // Delay for 2 seconds
        visible = !visible
    }
}
