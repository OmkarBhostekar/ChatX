package com.omkarcodes.chatx.presentation.screens.auth

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.omkarcodes.chatx.R
import com.omkarcodes.chatx.comman.Constants.defaultPadding
import com.omkarcodes.chatx.presentation.Screen
import com.omkarcodes.chatx.presentation.components.DefaultButton
import com.omkarcodes.chatx.presentation.ui.theme.colorLightText

@Composable
fun WelcomeScreen(
    navController: NavController
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = defaultPadding * 2),
    ) {
        Spacer(modifier = Modifier.weight(2f))
        Image(
            painter = painterResource(id = R.drawable.ic_welcome_illustration),
            contentDescription = null,
            modifier = Modifier
                .padding(horizontal = defaultPadding)
                .fillMaxWidth()
                .aspectRatio(1f)
        )
        Spacer(modifier = Modifier.weight(2f))
        Text(
            text = "Connect easily with your family and friends over countries",
            color = colorLightText,
            style = MaterialTheme.typography.h1,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(horizontal = defaultPadding)
        )
        Spacer(modifier = Modifier.weight(4f))
        Column(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Text(
                text = "Terms & Privacy Policy",
                color = colorLightText,
                style = MaterialTheme.typography.subtitle2,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(10.dp))
            DefaultButton(text = "Start Messaging") {
                navController.navigate(Screen.MobileNoScreen.route)
            }
        }
        Spacer(modifier = Modifier.weight(1f))
    }
}

