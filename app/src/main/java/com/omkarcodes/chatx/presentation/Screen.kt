package com.omkarcodes.chatx.presentation

sealed class Screen(val route: String) {

    object WelcomeScreen : Screen("welcome_screen")
    object MobileNoScreen : Screen("mobile_number_screen")
    object OtpScreen : Screen("otp_screen")
    object ProfileScreen : Screen("profile_screen")
    object ContactsScreen : Screen("contacts_screen")
    object AllChatsScreen : Screen("all_chats_screen")
    object ChatScreen : Screen("chat_screen")
    object MoreScreen : Screen("more_screen")

}