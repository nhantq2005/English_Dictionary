package com.example.englishdictionary.feature_dictionary.presentation.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.englishdictionary.ui.theme.AppTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchTextField(
    width: Float = 1f,
    textFieldValue: String,
    onValueChange: () -> Unit,
    onClickTrailingIcon: () -> Unit
) {
    TextField(
        value = textFieldValue,
        onValueChange = {
            onValueChange()
        },
        modifier = Modifier
            .fillMaxWidth(width)
            .shadow(elevation = 7.dp, shape = RoundedCornerShape(18.dp)),
        colors = TextFieldDefaults.textFieldColors(
            containerColor = AppTheme.appColor.textField,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            cursorColor = AppTheme.appColor.navIcon
        ),
        placeholder = {
            Text(
                text = "Word",
                style = AppTheme.appTypograhy.placeholder
            )
        },
        trailingIcon = {
            Icon(
                Icons.Default.Search,
                contentDescription = "Search Icon"
            )
        },
        shape = RoundedCornerShape(18.dp),
    )
}