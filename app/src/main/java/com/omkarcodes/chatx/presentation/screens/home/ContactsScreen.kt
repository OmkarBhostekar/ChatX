package com.omkarcodes.chatx.presentation.screens.home

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Divider
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.omkarcodes.chatx.R
import com.omkarcodes.chatx.comman.Constants
import com.omkarcodes.chatx.comman.Constants.contactList
import com.omkarcodes.chatx.comman.Constants.defaultPadding
import com.omkarcodes.chatx.presentation.components.ChatTile
import com.omkarcodes.chatx.presentation.components.ContactTile
import com.omkarcodes.chatx.presentation.components.CustomTopBar
import com.omkarcodes.chatx.presentation.components.SearchBar
import com.omkarcodes.chatx.presentation.model.TopBarAction
import com.omkarcodes.chatx.presentation.ui.theme.colorGrey3

@Composable
fun ContactsScreen(navController: NavController) {
    Scaffold(
        topBar = {
            CustomTopBar(
                title = "Contacts",
                actions = listOf(
                    TopBarAction(R.drawable.ic_add_contact){

                    },
                )
            )
        }
    ){
        LazyColumn(
            modifier = Modifier.fillMaxSize()
        ) {
            item {
                Spacer(modifier = Modifier.height(defaultPadding))
                SearchBar(modifier = Modifier.padding(horizontal = defaultPadding))
                Spacer(modifier = Modifier.height(defaultPadding))
            }
            items(contactList.size) {
                ContactTile(contact = contactList[it]) {

                }
            }
        }
    }
}