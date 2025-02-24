package com.example.englishdictionary.feature_dictionary.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.BookmarkBorder
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.outlined.Style
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.englishdictionary.ui.theme.AppTheme
import com.example.englishdictionary.util.Screen

@Composable
fun AppBar(
    navController: NavController,
    containerColor: Color,
    topBar: @Composable () -> Unit,
    content: @Composable () -> Unit
) {
//    List items in bottom bar
    val items = listOf(
        NavBarItem(
            route = Screen.MainScreen.route,
            label = Screen.MainScreen.lable,
            icon = Icons.Default.Search,
            isSelected = true
        ),
        NavBarItem(
            route = Screen.SavedWordScreen.route,
            label = Screen.SavedWordScreen.lable,
            icon = Icons.Default.BookmarkBorder,
            isSelected = false
        ),
        NavBarItem(
            route = Screen.FlashCardScreen.route,
            label = Screen.FlashCardScreen.lable,
            icon = Icons.Outlined.Style,
            isSelected = false
        )
    )
//  UI App bar
    Scaffold(
        topBar = {
            topBar()
        },
        bottomBar = {
            NavigationBar(
                containerColor = AppTheme.appColor.bottomBar,
                modifier = Modifier.shadow(
                    elevation = 10.dp,
                    shape = RoundedCornerShape(15.dp)
                )
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceAround
                ) {
                    items.forEachIndexed { _, item ->
                        val currenRoute = navController.currentDestination?.route
                        NavigationBarItem(
                            selected = currenRoute==item.route,
                            onClick = { navController.navigate(item.route) },
                            icon = {
                                Icon(
                                    item.icon,
                                    contentDescription = "Navigation Icon"
                                )
                            },
                            label = {
                                Text(text = item.label)
                            },
                            colors = NavigationBarItemDefaults.colors(
                                indicatorColor = AppTheme.appColor.selectedItem, // Orange for selected text
                            )
                        )
                    }
                }
            }
        },
        containerColor = containerColor
    ) { paddingValues ->
        Box(
            modifier = Modifier
                .padding(paddingValues)
        ) {
            content()
        }
    }
}

