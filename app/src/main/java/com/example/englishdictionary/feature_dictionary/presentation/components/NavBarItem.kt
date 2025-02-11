package com.example.englishdictionary.feature_dictionary.presentation.components

import androidx.compose.ui.graphics.vector.ImageVector

data class NavBarItem(
    val route:String,
    val label:String,
    val icon: ImageVector,
    val isSelected:Boolean
)