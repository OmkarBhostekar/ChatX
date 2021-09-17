package com.omkarcodes.chatx.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.omkarcodes.chatx.R

@Composable
fun BackButton(
    onClick: () -> Unit
) {
    Image(
        painter = painterResource(id = R.drawable.ic_back),
        contentDescription = null,
        modifier = Modifier
            .height(16.dp)
            .width(16.dp)
            .clickable {
                onClick()
            }
    )
}