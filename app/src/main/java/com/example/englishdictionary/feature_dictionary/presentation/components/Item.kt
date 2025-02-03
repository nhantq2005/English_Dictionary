package com.example.englishdictionary.feature_dictionary.presentation.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.englishdictionary.ui.theme.EnglishDictionaryTheme

@Composable
fun Item(
    key:String,
    value:String
){
    Row {
        Text(
            text = "$key:",
            fontWeight = FontWeight.SemiBold,
            modifier = Modifier.fillMaxWidth(0.25f)
        )
        Spacer(modifier = Modifier.width(5.dp))
        Text(text = value)
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewItem(){
    EnglishDictionaryTheme {
        Item(key = "Definition", value = "to decide that an organized event will not happen, or to stop an order for goods or services that you no longer want:")
    }
}