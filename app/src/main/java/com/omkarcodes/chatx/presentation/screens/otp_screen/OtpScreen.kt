package com.omkarcodes.chatx.presentation.screens.otp_screen

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusOrder
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.key.onKeyEvent
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.core.text.isDigitsOnly
import androidx.navigation.NavController
import com.omkarcodes.chatx.comman.Constants
import com.omkarcodes.chatx.comman.Constants.defaultPadding
import com.omkarcodes.chatx.presentation.Screen
import com.omkarcodes.chatx.presentation.components.BackButton
import com.omkarcodes.chatx.presentation.components.DefaultButton
import com.omkarcodes.chatx.presentation.components.MyTextButton
import com.omkarcodes.chatx.presentation.ui.theme.colorLightBackground2
import com.omkarcodes.chatx.presentation.ui.theme.colorLightText

@Composable
fun OtpScreen(navController: NavController, phoneNo: String?) {
    val focusManager = LocalFocusManager.current
    val digits = remember {
        mutableStateListOf(
            *((0 until 4).map { "" }.toTypedArray())
        )
    }
    val focusRequesters: List<FocusRequester> = remember {
        (0 until 4).map { FocusRequester() }
    }
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
            Spacer(modifier = Modifier.weight(2f))
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
            Row(
                modifier = Modifier
                    .fillMaxWidth(1f)
                    .wrapContentHeight(),
                Arrangement.SpaceBetween,
                Alignment.CenterVertically
            ) {
                (0 until 4).forEach { index ->
                    TextField(
                        modifier = Modifier
                            .weight(0.2f)
                            .padding(horizontal = 8.dp)
                            .background(colorLightBackground2)
                            .onKeyEvent {
                                if (it.nativeKeyEvent.keyCode == 67) {
                                    if (digits[index].isEmpty()) {
                                        focusManager.moveFocus(FocusDirection.Left)
                                    }
                                    digits[index] = ""
                                }
                                true
                            }
                            .clip(RoundedCornerShape(10.dp))
                            .padding(vertical = 2.dp)
                            .focusOrder(focusRequesters[index])
                            .focusRequester(focusRequesters[index]),
                        colors = TextFieldDefaults.textFieldColors(
                            textColor = colorLightText,
                            disabledTextColor = Color.Transparent,
                            focusedIndicatorColor = Color.Transparent,
                            unfocusedIndicatorColor =  Color.Transparent,
                            disabledIndicatorColor =  Color.Transparent,
                            backgroundColor = colorLightBackground2
                        ),
                        singleLine = true,
                        textStyle = MaterialTheme.typography.body1.copy(textAlign = TextAlign.Center),
                        value = digits[index],
                        onValueChange = {
                            if (digits[index].isEmpty() && it.isDigitsOnly()) {
                                digits[index] = it
                                focusManager.moveFocus(FocusDirection.Right)
                                if (index == 3 && digits.all { d -> d.isNotEmpty() }){
                                    // Check OTP and proceed
                                    navController.navigate(Screen.EditProfileScreen.route)
                                }
                            }
                        },
                        keyboardOptions = KeyboardOptions(
                            imeAction = ImeAction.Next,
                            keyboardType = KeyboardType.Number
                        ),
                        keyboardActions = KeyboardActions(
                            onNext = {
                                focusManager.moveFocus(FocusDirection.Right)
                            }
                        ),
                    )
                }
            }
            Spacer(modifier = Modifier.weight(1f))
            MyTextButton(text = "Resend Code") {
            }
            Spacer(modifier = Modifier.weight(4f))
        }
    }
}