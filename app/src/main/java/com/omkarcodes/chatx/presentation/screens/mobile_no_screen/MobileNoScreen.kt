package com.omkarcodes.chatx.presentation.screens.mobile_no_screen

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.omkarcodes.chatx.R
import com.omkarcodes.chatx.comman.Constants.defaultPadding
import com.omkarcodes.chatx.presentation.ui.theme.colorGrey2
import com.omkarcodes.chatx.presentation.ui.theme.colorLightBackground2
import com.omkarcodes.chatx.presentation.ui.theme.colorLightText
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardType
import androidx.navigation.NavController
import com.omkarcodes.chatx.presentation.Screen
import com.omkarcodes.chatx.presentation.components.BackButton
import com.omkarcodes.chatx.presentation.components.DefaultButton

@Composable
fun MobileNoScreen(navController: NavController) {
    var text by rememberSaveable { mutableStateOf("") }
    val context = LocalContext.current
    Scaffold {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = defaultPadding * 2),
            verticalArrangement = Arrangement.Top
        ) {
            Spacer(modifier = Modifier.height(defaultPadding* 2))
            BackButton {
                navController.popBackStack()
            }
            Spacer(modifier = Modifier.weight(3f))
            Text(
                text = "Enter Your Phone Number",
                style = MaterialTheme.typography.h1,
                color = colorLightText,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(defaultPadding))
            Text(
                text = "Please confirm your country code and enter your phone number",
                style = MaterialTheme.typography.caption,
                color = colorLightText,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.weight(1f))
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(48.dp)
            ) {
                Row(
                    modifier = Modifier
                        .weight(3f)
                        .fillMaxHeight()
                        .clip(RoundedCornerShape(5.dp))
                        .background(colorLightBackground2)
                        .padding(all = defaultPadding / 2),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.ic_india)  ,
                        contentDescription = null,
                        modifier = Modifier
                            .weight(2f)
                            .aspectRatio(1f),
                    )
                    Text(
                        text = "+91",
                        color = colorLightText,
                        textAlign = TextAlign.Center,
                        style = MaterialTheme.typography.caption,
                        modifier = Modifier.weight(3f)
                    )
                }
                Spacer(modifier = Modifier.width(defaultPadding/2))
                Row(
                    modifier = Modifier
                        .weight(9f)
                        .fillMaxHeight()
                        .clip(RoundedCornerShape(5.dp))
                        .background(colorLightBackground2),
                    verticalAlignment = CenterVertically,
                ) {
                    TextField(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(horizontal = defaultPadding / 2),
                        value = text,
                        onValueChange = {
                            text = it
                        },
                        placeholder = {
                            Text(text = "Phone Number",color = colorGrey2,style = MaterialTheme.typography.caption)
                        },
                        colors = TextFieldDefaults.textFieldColors(
                            textColor = colorLightText,
                            disabledTextColor = Color.Transparent,
                            focusedIndicatorColor = Color.Transparent,
                            unfocusedIndicatorColor =  Color.Transparent,
                            disabledIndicatorColor =  Color.Transparent,
                            backgroundColor = colorLightBackground2
                        ),
                        textStyle = MaterialTheme.typography.caption,
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
                    )
                }
            }
            Spacer(modifier = Modifier.weight(1f))
            DefaultButton(text = "Continue") {
                if (text.isNotEmpty())
                    navController.navigate(Screen.OtpScreen.route + "/$text")
                else
                    Toast.makeText(context, "Please enter phone number", Toast.LENGTH_SHORT).show()
            }
            Spacer(modifier = Modifier.weight(4f))
        }
    }
}