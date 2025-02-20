package com.example.englishdictionary.feature_dictionary.presentation.flashcard_screen

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.englishdictionary.ui.theme.AppTheme
import kotlinx.coroutines.delay

@Composable
fun DemoBtn() {
//    IconButton(onClick = { /*TODO*/ },
//        modifier = Modifier.padding(15.dp)
//            .shadow(15.dp, RoundedCornerShape(7.dp)),
//        colors = IconButtonDefaults.iconButtonColors(Color.Transparent)) {
//        Icon(Icons.Default.Check, contentDescription = null)
//    }
//    Icon(Icons.Default.Check,contentDescription = null,
//        modifier = Modifier.padding(15.dp)
//            .shadow(5.dp)
//            .size(5.dp)
//            .clip(RoundedCornerShape(25.dp))
//            .background(Color.Blue))

//    IconButton(onClick = { /*TODO*/ },
//        colors = IconButtonDefaults.iconButtonColors(Color.DarkGray),
//        modifier = Modifier
//            .size(25.dp)
////            .clip(RoundedCornerShape(9.dp))
//            .shadow(20.dp, RoundedCornerShape(9.dp))
//
//    ) {
//        Icon(Icons.Default.Check , contentDescription = null)
//    }

    IconButton(
        onClick = {},
        modifier = Modifier
            .background(Color.White, shape = CircleShape)
            .shadow(8.dp, shape = CircleShape) // Shadow effect
            .size(56.dp) // Adjust size as needed
    ) {
        Icon(
            imageVector = Icons.Default.Check,
            contentDescription = null,
            tint = Color.Blue,
            modifier = Modifier.size(24.dp) // Adjust icon size
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewBtn(){
    AppTheme {
        DemoBtn()
    }
}
