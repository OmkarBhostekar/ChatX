package com.omkarcodes.chatx.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.omkarcodes.chatx.comman.Constants.defaultPadding
import com.omkarcodes.chatx.presentation.model.TopBarAction
import com.omkarcodes.chatx.presentation.ui.theme.colorLightText


@Composable
fun CustomTopBar(
    title: String,
    actions: List<TopBarAction> = emptyList()
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(50.dp)
            .padding(horizontal = defaultPadding)
            .background(MaterialTheme.colors.background),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = title,
            fontSize = 19.sp,
            color = colorLightText,
            fontWeight = FontWeight.SemiBold
        )
        Row {
            actions.forEachIndexed { i,action ->
                Image(
                    painter = painterResource(id = action.icon),
                    contentDescription = action.desc,
                    modifier = Modifier
                        .width(36.dp)
                        .height(36.dp)
                        .padding(5.dp)
                        .scale(1f)
                        .clickable {
                            action.onClick()
                        }
                )
                if (i != actions.size -1)
                    Spacer(modifier = Modifier.width(defaultPadding/2))
            }
        }
    }
}

