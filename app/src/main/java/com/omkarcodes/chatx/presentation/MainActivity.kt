package com.omkarcodes.chatx.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.*
import com.omkarcodes.chatx.presentation.components.BottomNavigationBar
import com.omkarcodes.chatx.presentation.model.NavigationItem
import com.omkarcodes.chatx.presentation.screens.auth.MobileNoScreen
import com.omkarcodes.chatx.presentation.screens.auth.OtpScreen
import com.omkarcodes.chatx.presentation.screens.auth.WelcomeScreen
import com.omkarcodes.chatx.presentation.screens.home.ChatListScreen
import com.omkarcodes.chatx.presentation.screens.home.ChatScreen
import com.omkarcodes.chatx.presentation.screens.home.ContactsScreen
import com.omkarcodes.chatx.presentation.screens.home.MoreScreen
import com.omkarcodes.chatx.presentation.screens.profile.EditProfileScreen
import com.omkarcodes.chatx.presentation.ui.theme.ChatXTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ChatXTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    val navController = rememberNavController()
                    Scaffold(
                        bottomBar = {
                            val currentRoute = currentRoute(navController)
                            if (currentRoute == NavigationItem.Contacts.route
                                || currentRoute == NavigationItem.Chats.route
                                || currentRoute == NavigationItem.More.route){
                                BottomNavigationBar(navController = navController)
                            }
                        }
                    ) {
                        Box(modifier = Modifier.padding(bottom = it.calculateBottomPadding())) {
                            Navigation(navController = navController)
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun Navigation(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Screen.WelcomeScreen.route
    ) {
        composable(Screen.WelcomeScreen.route){
            WelcomeScreen(navController = navController)
        }
        composable(Screen.MobileNoScreen.route){
            MobileNoScreen(navController = navController)
        }
        composable(
            route = Screen.OtpScreen.route + "/{phoneNo}",
            arguments = listOf(navArgument("phoneNo") { type = NavType.StringType })
        ){ backStackEntry ->
            OtpScreen(navController = navController,backStackEntry.arguments?.getString("phoneNo"))
        }
        composable(
            route = Screen.EditProfileScreen.route
        ){
            EditProfileScreen(navController = navController)
        }
        composable(
            route = Screen.ChatScreen.route + "/{name}",
            arguments = listOf(navArgument("name") { type = NavType.StringType })
        ){  backStackEntry ->
            ChatScreen(navController = navController,backStackEntry.arguments?.getString("name"))
        }
        composable(NavigationItem.Contacts.route){
            ContactsScreen(navController)
        }
        composable(NavigationItem.Chats.route){
            ChatListScreen(navController)
        }
        composable(NavigationItem.More.route){
            MoreScreen(navController)
        }
    }
}

@Composable
fun currentRoute(navController: NavHostController): String? {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    return navBackStackEntry?.destination?.route
}