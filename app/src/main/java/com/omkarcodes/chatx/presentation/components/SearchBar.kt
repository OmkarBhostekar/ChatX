package com.omkarcodes.chatx.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.omkarcodes.chatx.R
import com.omkarcodes.chatx.comman.Constants
import com.omkarcodes.chatx.presentation.ui.theme.colorGrey2
import com.omkarcodes.chatx.presentation.ui.theme.colorLightBackground2
import com.omkarcodes.chatx.presentation.ui.theme.colorLightText

@Composable
fun SearchBar(
    modifier: Modifier = Modifier
) {
    var text by rememberSaveable { mutableStateOf("") }
    TextField(
        modifier = modifier
            .fillMaxWidth()
            .height(48.dp),
        value = text,
        onValueChange = {
            text = it
        },
        placeholder = {
            Text(text = "Search...",color = colorGrey2,style = MaterialTheme.typography.body2)
        },
        leadingIcon = {
            Image(
                painter = painterResource(id = R.drawable.ic_search),
                contentDescription = null,
                modifier = Modifier
                    .size(24.dp),
                colorFilter = ColorFilter.tint(color = colorGrey2)
            )
        },
        colors = TextFieldDefaults.textFieldColors(
            textColor = colorLightText,
            disabledTextColor = Color.Transparent,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor =  Color.Transparent,
            disabledIndicatorColor =  Color.Transparent,
            backgroundColor = colorLightBackground2
        ),
        textStyle = MaterialTheme.typography.body2,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
        shape = RoundedCornerShape(12.dp)
    )
}