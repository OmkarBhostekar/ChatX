package com.omkarcodes.chatx.presentation.screens.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.omkarcodes.chatx.R
import com.omkarcodes.chatx.comman.Constants
import com.omkarcodes.chatx.comman.Constants.defaultPadding
import com.omkarcodes.chatx.presentation.Screen
import com.omkarcodes.chatx.presentation.components.ContactTile
import com.omkarcodes.chatx.presentation.components.CustomTopBar
import com.omkarcodes.chatx.presentation.components.SearchBar
import com.omkarcodes.chatx.presentation.model.TopBarAction
import com.omkarcodes.chatx.presentation.ui.theme.colorGrey2
import com.omkarcodes.chatx.presentation.ui.theme.colorLightBackground2
import com.omkarcodes.chatx.presentation.ui.theme.colorLightText

@Composable
fun MoreScreen(navController: NavController) {
    Scaffold(
        topBar = {
            CustomTopBar(
                title = "More",
            )
        }
    ){
        LazyColumn(
            modifier = Modifier.fillMaxSize()
        ) {
            item {
                Spacer(modifier = Modifier.height(defaultPadding))
                MyAccountTile {
                    navController.navigate(Screen.EditProfileScreen.route)
                }
                Spacer(modifier = Modifier.height(defaultPadding*2))
                SettingTile(name = "Account", icon = R.drawable.ic_avatar) {

                }
                SettingTile(name = "Chats", icon = R.drawable.ic_chat_setting) {

                }
                SettingTile(name = "Appearance", icon = R.drawable.ic_appearance) {

                }
                SettingTile(name = "Notifications", icon = R.drawable.ic_notifications) {

                }
                SettingTile(name = "Privacy", icon = R.drawable.ic_privacy) {

                }
                SettingTile(name = "Data Usage", icon = R.drawable.ic_data_usage) {

                }
                SettingTile(name = "Help", icon = R.drawable.ic_help) {

                }
                SettingTile(name = "Invite Your Friends", icon = R.drawable.ic_invite) {

                }
            }
        }
    }
}

@Composable
fun MyAccountTile(
    onClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(66.dp)
            .clickable {
                onClick()
            }
            .padding(vertical = defaultPadding / 2, horizontal = defaultPadding),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .size(50.dp)
                .clip(CircleShape)
                .background(colorLightBackground2)
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_avatar),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(defaultPadding)
            )
        }
        Spacer(modifier = Modifier.width(defaultPadding))
        Column(
            modifier = Modifier
                .weight(1f)
                .fillMaxHeight(),
            verticalArrangement = Arrangement.SpaceEvenly
        ) {
            Text(
                text = "Omkar Bhostekar",
                maxLines = 1,
                style = MaterialTheme.typography.body1,
                fontWeight = FontWeight.SemiBold,
                overflow = TextOverflow.Ellipsis,
                color = colorLightText,
            )
            Text(
                text = "+91 77000 84212",
                maxLines = 1,
                style = MaterialTheme.typography.caption,
                overflow = TextOverflow.Ellipsis,
                color = colorGrey2,
            )
        }
        Spacer(modifier = Modifier.width(defaultPadding))
        Image(
            painter = painterResource(id = R.drawable.ic_arrow_next),
            contentDescription = null,
            modifier = Modifier
                .size(24.dp)
                .padding(5.dp)
        )
    }
}

@Composable
fun SettingTile(
    name: String,
    icon: Int,
    onClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(all = defaultPadding),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = icon),
            contentDescription = null,
            modifier = Modifier
                .size(24.dp)
        )
        Spacer(modifier = Modifier.width(defaultPadding))
        Text(
            text = name,
            color = colorLightText,
            modifier = Modifier.weight(1f),
        )
        Spacer(modifier = Modifier.width(defaultPadding))
        Image(
            painter = painterResource(id = R.drawable.ic_arrow_next),
            contentDescription = null,
            modifier = Modifier
                .size(24.dp)
                .padding(5.dp)
        )
    }
}