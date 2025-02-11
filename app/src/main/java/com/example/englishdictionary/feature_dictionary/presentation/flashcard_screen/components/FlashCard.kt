package com.example.englishdictionary.feature_dictionary.presentation.flashcard_screen.components

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.englishdictionary.ui.theme.EnglishDictionaryTheme

@Composable
fun FlashCard() {
    var flipped by rememberSaveable { mutableStateOf(false) }
    val rotation by animateFloatAsState(targetValue = if (flipped) 0f else 180f, label = "")
    var value = if (!flipped) -1f else 1f
    Card(
        modifier = Modifier
            .fillMaxWidth(0.7f)
            .fillMaxHeight(0.4f)
            .graphicsLayer {
                rotationY = rotation
                cameraDistance = 8 * density
                scaleX = value
            }
            .clickable { flipped = !flipped },
        shape = RoundedCornerShape(20.dp),
        elevation = CardDefaults.cardElevation(15.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.primary

        )
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier.fillMaxSize()
        ) {
            Text(
                text = if (flipped) "Back" else "Front",
                fontSize = 24.sp,
                color = MaterialTheme.colorScheme.onPrimary,

                )
        }
    }

}


@Preview(showBackground = true)
@Composable
fun PreviewFlashCard() {
    EnglishDictionaryTheme {
        FlashCard()
    }
}