package com.omkarcodes.chatx.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.omkarcodes.chatx.R
import com.omkarcodes.chatx.comman.Constants.defaultPadding
import com.omkarcodes.chatx.presentation.model.ChatInfo
import com.omkarcodes.chatx.presentation.ui.theme.*

@Composable
fun ChatTile(
    chatInfo: ChatInfo,
    onClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(66.dp)
            .clickable { onClick() }
            .padding(vertical = defaultPadding / 2, horizontal = defaultPadding)
    ){
        Box(
            modifier = Modifier
                .size(50.dp)
        ) {
            Image(
                painter = painterResource(id = chatInfo.image),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxSize(),
                contentScale = ContentScale.Crop
            )
            if (chatInfo.isOnline)
            Box(
                modifier = Modifier
                    .size(15.dp)
                    .border(
                        width = 2.dp,
                        color = Color.White,
                        shape = CircleShape
                    )
                    .clip(CircleShape)
                    .background(color = colorActiveGreen)
                    .align(Alignment.TopEnd)
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
                text = chatInfo.name,
                maxLines = 1,
                style = MaterialTheme.typography.body2,
                fontWeight = FontWeight.SemiBold,
                overflow = TextOverflow.Ellipsis,
                color = colorLightText,
            )
            Text(
                text = chatInfo.lastMessage,
                maxLines = 1,
                style = MaterialTheme.typography.caption,
                overflow = TextOverflow.Ellipsis,
                color = colorGrey2,
            )
        }
        Spacer(modifier = Modifier.width(defaultPadding))
        Column(
            modifier = Modifier
                .fillMaxHeight(),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = chatInfo.msgTime,
                maxLines = 1,
                fontSize = 10.sp,
                color = colorGrey2,
            )
            if (chatInfo.unreadMsgCount > 0)
            Box(
                modifier = Modifier
                    .size(18.dp)
                    .clip(CircleShape)
                    .background(colorBlue20)
            ) {
                Text(
                    text = chatInfo.unreadMsgCount.toString(),
                    fontSize = 9.sp,
                    color = colorBlue700,
                    modifier = Modifier.align(Alignment.Center)
                )
            }
        }
    }
}