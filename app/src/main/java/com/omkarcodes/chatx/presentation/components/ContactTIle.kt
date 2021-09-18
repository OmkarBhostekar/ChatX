package com.omkarcodes.chatx.presentation.components

import android.widget.Space
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Divider
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
import com.omkarcodes.chatx.comman.Constants
import com.omkarcodes.chatx.comman.Constants.defaultPadding
import com.omkarcodes.chatx.presentation.model.ContactInfo
import com.omkarcodes.chatx.presentation.ui.theme.*

@Composable
fun ContactTile(
    contact: ContactInfo,
    onClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
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
                    painter = painterResource(id = contact.image),
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxSize(),
                    contentScale = ContentScale.Crop
                )
                if (contact.isOnline)
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
                    .fillMaxHeight()
                    .padding(bottom = defaultPadding/2),
                verticalArrangement = Arrangement.SpaceEvenly
            ) {
                Text(
                    text = contact.name,
                    maxLines = 1,
                    style = MaterialTheme.typography.body2,
                    fontWeight = FontWeight.SemiBold,
                    overflow = TextOverflow.Ellipsis,
                    color = colorLightText,
                )
                Text(
                    text = contact.lastSeen,
                    maxLines = 1,
                    style = MaterialTheme.typography.caption,
                    overflow = TextOverflow.Ellipsis,
                    color = colorGrey2,
                )
            }
        }
        Spacer(Modifier.height(defaultPadding/2))
        Divider(
            color = colorGrey3,
            thickness = 0.6.dp,
            modifier = Modifier.padding(horizontal = defaultPadding*2)
        )
        Spacer(Modifier.height(defaultPadding))
    }
}