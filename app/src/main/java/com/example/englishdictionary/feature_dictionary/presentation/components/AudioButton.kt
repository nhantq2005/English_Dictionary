package com.example.englishdictionary.feature_dictionary.presentation.components

import android.media.MediaPlayer
import android.net.Uri
import android.util.Log
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.VolumeUp
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.io.IOException

@Composable
fun AudioButton(
    audioUrl: String
) {

//    val context = LocalContext.current
    var isPlaying by remember { mutableStateOf(false) }
    var mediaPlayer by remember { mutableStateOf<MediaPlayer?>(null) }

    IconButton(
        onClick = {
            if (mediaPlayer == null) {
                mediaPlayer = MediaPlayer()
                CoroutineScope(Dispatchers.IO).launch {
                    try {
                        mediaPlayer?.apply {
                            setDataSource(audioUrl)
                            prepare()
                            start()
                            withContext(Dispatchers.Main) {
                                isPlaying = true
                            }
                        }
                    } catch (e: IOException) {
                        e.printStackTrace()
                    }
                }
            } else {
                mediaPlayer?.start()
            }
        }
    ) {
        Icon(
            Icons.Default.VolumeUp,
            contentDescription = "Phonetic button",
            modifier = Modifier
                .size(15.dp)
                .padding(vertical = 0.dp)
        )
    }
}
