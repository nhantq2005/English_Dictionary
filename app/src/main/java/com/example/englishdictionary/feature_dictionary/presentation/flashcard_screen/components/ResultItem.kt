package com.example.englishdictionary.feature_dictionary.presentation.flashcard_screen.components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.englishdictionary.ui.theme.AppTheme

@Composable
fun ResultItem(
    countRightWord: Int,
    countWrongWord: Int
) {
    Column(
        Modifier.fillMaxWidth(0.6f)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = "Know: ", style = AppTheme.appTypograhy.countValue.copy(fontSize = 25.sp))
            Text(
                text = "$countRightWord",
                style = AppTheme.appTypograhy.countValue,
                color = AppTheme.appColor.right,
                modifier = Modifier
                    .border(2.dp, AppTheme.appColor.right, RoundedCornerShape(15.dp))
                    .padding(8.dp)
            )
        }
        Spacer(modifier = Modifier.padding(vertical = 5.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = "Still learning: ", style = AppTheme.appTypograhy.countValue.copy(fontSize = 25.sp))
            Text(
                text = "$countWrongWord",
                style = AppTheme.appTypograhy.countValue,
                color = AppTheme.appColor.wrong,
                modifier = Modifier
                    .border(2.dp, AppTheme.appColor.wrong, RoundedCornerShape(15.dp))
                    .padding(8.dp)
            )
        }
        Spacer(modifier = Modifier.padding(vertical = 5.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = "Ratio: ", style = AppTheme.appTypograhy.countValue.copy(fontSize = 25.sp))
            Text(
                text = "${countRightWord * 100 / (countWrongWord + countRightWord)}%",
                style = AppTheme.appTypograhy.countValue,
                modifier = Modifier
                    .border(2.dp, Color.Black, RoundedCornerShape(15.dp))
                    .padding(8.dp)
            )
        }
    }
}
