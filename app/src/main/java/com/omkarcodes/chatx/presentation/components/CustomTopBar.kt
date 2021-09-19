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
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.omkarcodes.chatx.comman.Constants.defaultPadding
import com.omkarcodes.chatx.presentation.model.TopBarAction
import com.omkarcodes.chatx.presentation.ui.theme.colorLightText


@Composable
fun CustomTopBar(
    title: String,
    titleFontSize: TextUnit = 19.sp,
    actions: List<TopBarAction> = emptyList(),
    backButtonEnabled: Boolean = false,
    onBackPressed: () -> Unit = {  }
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
        Row(
            modifier = Modifier.weight(1f),
            verticalAlignment = Alignment.CenterVertically
        ) {
            if (backButtonEnabled){
                BackButton {
                    onBackPressed()
                }
                Spacer(modifier = Modifier.width(defaultPadding))
            }
            Text(
                text = title,
                fontSize = titleFontSize,
                color = colorLightText,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier.weight(1f),
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        }
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Spacer(modifier = Modifier.width(defaultPadding))
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

