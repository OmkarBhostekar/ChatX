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
import com.omkarcodes.chatx.presentation.screens.home.ChatScreen
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
        startDestination = NavigationItem.Chats.route
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
        composable(NavigationItem.Contacts.route){
            Scaffold {

            }
        }
        composable(NavigationItem.Chats.route){
            ChatScreen(navController)
        }
        composable(NavigationItem.More.route){
            Scaffold {

            }
        }
    }
}

@Composable
fun currentRoute(navController: NavHostController): String? {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    return navBackStackEntry?.destination?.route
}