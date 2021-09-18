package com.omkarcodes.chatx.presentation.components

import androidx.compose.foundation.layout.size
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.omkarcodes.chatx.presentation.model.NavigationItem
import com.omkarcodes.chatx.presentation.ui.theme.colorGrey2

@Composable
fun BottomNavigationBar(navController: NavController) {
    val items = listOf(
        NavigationItem.Contacts,
        NavigationItem.Chats,
        NavigationItem.More,
    )
    BottomNavigation(
        backgroundColor = Color.White,
        contentColor = Color.Black
    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route
        items.forEach {
            BottomNavigationItem(
                icon = { Icon(painter = painterResource(id = it.icon), contentDescription = it.title, modifier = Modifier.size(18.dp)) },
                label = { Text(text = it.title, fontSize = 10.sp, color = Color.Black, maxLines = 1, overflow = TextOverflow.Ellipsis) },
                selectedContentColor = Color.Black,
                unselectedContentColor = colorGrey2,
                alwaysShowLabel = false,
                selected = currentRoute == it.route,
                onClick = {
                    navController.navigate(it.route)
                },
            )
        }
    }
}