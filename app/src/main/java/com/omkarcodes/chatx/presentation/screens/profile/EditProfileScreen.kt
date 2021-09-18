package com.omkarcodes.chatx.presentation.screens.profile

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.omkarcodes.chatx.comman.Constants.defaultPadding
import com.omkarcodes.chatx.presentation.components.BackButton
import com.omkarcodes.chatx.presentation.ui.theme.colorLightBackground2
import com.omkarcodes.chatx.presentation.ui.theme.colorLightText
import com.omkarcodes.chatx.R
import com.omkarcodes.chatx.presentation.model.NavigationItem
import com.omkarcodes.chatx.presentation.components.DefaultButton
import com.omkarcodes.chatx.presentation.ui.theme.colorGrey2

@Composable
fun EditProfileScreen(navController: NavController) {
    var firstName by rememberSaveable { mutableStateOf("") }
    var lastName by rememberSaveable { mutableStateOf("") }
    val context = LocalContext.current
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = defaultPadding * 2),
    ) {
        Spacer(modifier = Modifier.height(defaultPadding * 2))
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            BackButton {
                navController.popBackStack()
            }
            Spacer(modifier = Modifier.width(defaultPadding*2))
            Text(
                text = "Your Profile",
                style = MaterialTheme.typography.body1,
                color = colorLightText,
                fontWeight = FontWeight.Bold
            )
        }
        Spacer(modifier = Modifier.weight(2f))
        AddProfilePicture()
        Spacer(modifier = Modifier.height(defaultPadding*3))
        TextField(
            modifier = Modifier
                .fillMaxWidth()
                .height(48.dp)
                .padding(horizontal = defaultPadding / 2),
            value = firstName,
            onValueChange = {
                firstName = it
            },
            placeholder = {
                Text(text = "First Name (Required)",color = colorGrey2,style = MaterialTheme.typography.caption)
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
        )
        Spacer(modifier = Modifier.height(defaultPadding*2))
        TextField(
            modifier = Modifier
                .fillMaxWidth()
                .height(48.dp)
                .padding(horizontal = defaultPadding / 2),
            value = lastName,
            onValueChange = {
                lastName = it
            },
            placeholder = {
                Text(text = "Last Name (Optional)",color = colorGrey2,style = MaterialTheme.typography.caption)
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
        )
        Spacer(modifier = Modifier.weight(1f))
        DefaultButton(text = "Save") {
            if (firstName.isNotEmpty())
                navController.navigate(NavigationItem.Chats.route)
            else
                Toast.makeText(context, "Please enter first name", Toast.LENGTH_SHORT).show()
        }
        Spacer(modifier = Modifier.weight(4f))
    }
}

@Composable
fun AddProfilePicture() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center
    ) {
        Box(
            modifier = Modifier
                .width(120.dp)
                .aspectRatio(1f)
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_avatar),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxSize()
                    .clip(CircleShape)
                    .background(color = colorLightBackground2)
                    .padding(all = defaultPadding * 2)
            )
            FloatingActionButton(
                onClick = {  },
                modifier = Modifier
                    .align(Alignment.BottomEnd)
                    .size(30.dp)
                    .shadow(elevation = 0.dp),
                backgroundColor = colorLightText
            ) {
                Text(text = "+",color = Color.White,fontSize = 16.sp)
            }
        }
    }
}