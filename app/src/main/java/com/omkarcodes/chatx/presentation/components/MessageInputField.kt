package com.omkarcodes.chatx.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.omkarcodes.chatx.presentation.ui.theme.colorBlue500
import com.omkarcodes.chatx.presentation.ui.theme.colorGrey2
import com.omkarcodes.chatx.presentation.ui.theme.colorLightBackground2
import com.omkarcodes.chatx.presentation.ui.theme.colorLightText


@Composable
fun MessageInputField(
    modifier: Modifier = Modifier,
    text: String,
    hintText: String = "Type a Message",
    onChanged: (t: String) -> Unit
) {
    BasicTextField(
        value = text,
        onValueChange = onChanged ,
        decorationBox = { innerTextField ->
            Box(
                modifier = modifier
                    .fillMaxWidth()
                    .height(40.dp)
                    .clip(RoundedCornerShape(5.dp))
                    .background(colorLightBackground2)
                    .padding(8.dp)
            ) {
                if (text.isEmpty()){
                    Text(
                        text = hintText,
                        color = colorGrey2,
                        fontSize = 14.sp,
                        modifier = Modifier.align(Alignment.CenterStart)
                    )
                }
                innerTextField()
            }
        },
        textStyle = TextStyle(
            fontSize = 14.sp,
            color = colorLightText,
        ),
        cursorBrush = Brush.linearGradient(colors = listOf(colorBlue500, colorBlue500)),
        maxLines = 1,
        singleLine = true
    )
}