package com.omkarcodes.chatx.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navArgument
import androidx.navigation.compose.rememberNavController
import com.omkarcodes.chatx.presentation.screens.edit_profile_screen.EditProfileScreen
import com.omkarcodes.chatx.presentation.screens.mobile_no_screen.MobileNoScreen
import com.omkarcodes.chatx.presentation.screens.otp_screen.OtpScreen
import com.omkarcodes.chatx.presentation.ui.theme.ChatXTheme
import com.omkarcodes.chatx.presentation.screens.welcome_screen.WelcomeScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ChatXTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    val navController = rememberNavController()
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
                    }
                }
            }
        }
    }
}
