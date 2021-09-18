package com.omkarcodes.chatx.presentation.screens.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.omkarcodes.chatx.R
import com.omkarcodes.chatx.comman.Constants
import com.omkarcodes.chatx.presentation.model.Story
import com.omkarcodes.chatx.presentation.ui.theme.colorGrey2
import com.omkarcodes.chatx.presentation.ui.theme.colorLightBackground2
import com.omkarcodes.chatx.presentation.ui.theme.colorLightText


@Composable
fun StorySection(
    stories: List<Story>,
    modifier: Modifier = Modifier
) {
    LazyRow(

    ) {
        item {
            Spacer(modifier = Modifier.width(Constants.defaultPadding))
            YourStory()
            Spacer(modifier = Modifier.width(Constants.defaultPadding))
        }
        items(stories.size){
            Story(story = stories[it])
            Spacer(modifier = Modifier.width(Constants.defaultPadding))
        }
    }
}

@Composable
fun YourStory() {
    Column(
        modifier = Modifier
            .width(60.dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(1f)
                .border(
                    width = 2.dp,
                    color = colorGrey2,
                    shape = RoundedCornerShape(20.dp)
                )
                .padding(3.dp)
                .clip(RoundedCornerShape(20.dp))
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_add),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxSize()
                    .background(colorLightBackground2)
                    .padding(20.dp)
            )
        }
        Spacer(modifier = Modifier.height(Constants.defaultPadding /2))
        Text(
            text = "Your Story",
            modifier = Modifier.fillMaxWidth(),
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            color = colorLightText,
            fontSize = 11.sp,
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.SemiBold
        )
    }
}

@Composable
fun Story(
    story: Story
) {
    val borderColor = if (story.isViewed) Brush.linearGradient(
        colors = listOf(colorGrey2, colorGrey2)
    ) else Brush.linearGradient(
        colors = listOf(
            Color(0xFFD2D5F9),
            Color(0xFF2C37E1)
        )
    )
    Column(
        modifier = Modifier
            .width(60.dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(1f)
                .border(
                    width = 2.dp,
                    brush = borderColor,
                    shape = RoundedCornerShape(20.dp)
                )
                .padding(3.dp)
                .clip(RoundedCornerShape(20.dp))
        ) {
            Image(
                painter = painterResource(id = story.image),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxSize(),
                contentScale = ContentScale.FillBounds
            )
        }
        Spacer(modifier = Modifier.height(Constants.defaultPadding /2))
        Text(
            text = story.name,
            modifier = Modifier.fillMaxWidth(),
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            color = colorLightText,
            fontSize = 11.sp,
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.SemiBold
        )
    }
}