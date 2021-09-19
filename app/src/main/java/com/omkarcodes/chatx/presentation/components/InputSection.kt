package com.omkarcodes.chatx.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.omkarcodes.chatx.R
import com.omkarcodes.chatx.comman.Constants
import com.omkarcodes.chatx.presentation.ui.theme.colorBlue500


@Composable
fun InputSection(
    text: String,
    onChanged: (t: String) -> Unit,
    onMoreClick: () -> Unit,
    onSendClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(60.dp)
            .background(Color.White)
            .padding(
                start = Constants.defaultPadding / 2,
                end = Constants.defaultPadding / 2,
                bottom = Constants.defaultPadding / 3
            ),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_add),
            contentDescription = null,
            modifier = Modifier
                .size(40.dp)
                .clickable { onMoreClick() }
                .padding(13.dp)
        )
        Spacer(modifier = Modifier.width(Constants.defaultPadding /3))
        Box(
            modifier = Modifier.weight(1f)
        ) {
            MessageInputField(
                text = text,
                onChanged = onChanged,
                hintText = "Type a Message"
            )
        }
        Spacer(modifier = Modifier.width(Constants.defaultPadding /3))
        Image(
            painter = painterResource(id = R.drawable.ic_send),
            contentDescription = null,
            modifier = Modifier
                .size(40.dp)
                .clickable { onSendClick() }
                .padding(7.dp),
            colorFilter = ColorFilter.tint(colorBlue500)
        )
    }
}