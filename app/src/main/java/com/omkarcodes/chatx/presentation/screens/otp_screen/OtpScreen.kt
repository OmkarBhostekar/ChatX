package com.omkarcodes.chatx.presentation.screens.otp_screen

import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.navigation.NavController
import com.omkarcodes.chatx.comman.Constants
import com.omkarcodes.chatx.comman.Constants.defaultPadding
import com.omkarcodes.chatx.presentation.components.BackButton
import com.omkarcodes.chatx.presentation.ui.theme.colorLightText

@Composable
fun OtpScreen(navController: NavController, phoneNo: String?) {
    Scaffold {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = Constants.defaultPadding * 2),
            verticalArrangement = Arrangement.Top
        ){
            Spacer(modifier = Modifier.height(defaultPadding* 2))
            BackButton {
                navController.popBackStack()
            }
            Spacer(modifier = Modifier.weight(3f))
            Text(
                text = "Enter Code",
                style = MaterialTheme.typography.h1,
                color = colorLightText,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(Constants.defaultPadding))
            Text(
                text = "We have sent you an SMS with the code\n to +91 $phoneNo",
                style = MaterialTheme.typography.caption,
                color = colorLightText,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.weight(1f))
        }
    }
}