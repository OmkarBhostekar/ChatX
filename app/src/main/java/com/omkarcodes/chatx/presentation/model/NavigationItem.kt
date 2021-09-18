package com.omkarcodes.chatx.presentation.model

import com.omkarcodes.chatx.R

sealed class NavigationItem(var route: String, var icon: Int, var title: String){
    object Contacts: NavigationItem("contacts", R.drawable.ic_contacts,"Contacts")
    object Chats: NavigationItem("chats", R.drawable.ic_chats,"Chats")
    object More: NavigationItem("more", R.drawable.ic_more,"More")
}