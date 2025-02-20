package com.example.englishdictionary.feature_dictionary.presentation.main_screen.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.englishdictionary.feature_dictionary.presentation.components.AudioButton
import com.example.englishdictionary.ui.theme.AppTheme

@Composable
fun PhoneticItem(
    phonetic:String,
    url:String
){
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceAround
    ) {
        Text(
            text = phonetic,
            style = AppTheme.appTypograhy.phonetic
        )
        if(url.isNotEmpty()) {
            AudioButton(audioUrl = url)
        }
    }
    Spacer(modifier = Modifier.padding(horizontal = 10.dp))
}

@Preview(showBackground = true)
@Composable
fun PreviewPhoneticItem(){
    AppTheme {
        PhoneticItem(phonetic = "/ˈkænsl̩/", url = "A")
    }
}