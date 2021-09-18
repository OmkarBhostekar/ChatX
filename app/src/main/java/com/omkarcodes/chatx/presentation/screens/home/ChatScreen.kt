package com.omkarcodes.chatx.presentation.screens.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
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
import androidx.navigation.NavController
import com.omkarcodes.chatx.presentation.model.TopBarAction
import com.omkarcodes.chatx.R
import com.omkarcodes.chatx.comman.Constants.chatList
import com.omkarcodes.chatx.comman.Constants.defaultPadding
import com.omkarcodes.chatx.presentation.components.ChatTile
import com.omkarcodes.chatx.presentation.components.CustomTopBar
import com.omkarcodes.chatx.presentation.components.SearchBar
import com.omkarcodes.chatx.presentation.model.Story
import com.omkarcodes.chatx.presentation.ui.theme.colorGrey2
import com.omkarcodes.chatx.presentation.ui.theme.colorGrey3
import com.omkarcodes.chatx.presentation.ui.theme.colorLightBackground2
import com.omkarcodes.chatx.presentation.ui.theme.colorLightText

@Composable
fun ChatScreen(navController: NavController) {
    Scaffold(
        topBar = {
            CustomTopBar(
                title = "Chats",
                actions = listOf(
                    TopBarAction(R.drawable.ic_new_chat){

                    },
                    TopBarAction(R.drawable.ic_mark_as_read){

                    },
                )
            )
        }
    ) {
        LazyColumn(
          modifier = Modifier.fillMaxSize()
        ) {
            item {
                Spacer(modifier = Modifier.height(defaultPadding/2))
                StorySection(
                    stories = listOf(
                        Story(R.drawable.ic_story_1,"Prathmesh",false),
                        Story(R.drawable.ic_story_1,"Saurabh",true),
                        Story(R.drawable.ic_story_1,"Mahesh",false),
                        Story(R.drawable.ic_story_1,"Akash",false),
                        Story(R.drawable.ic_story_1,"Nehal",false),
                        Story(R.drawable.ic_story_1,"Pushkaraj",false),
                        Story(R.drawable.ic_story_1,"Tejas",false),
                        Story(R.drawable.ic_story_1,"Sanket",false),
                    )
                )
                Spacer(modifier = Modifier.height(defaultPadding*2))
                Divider(
                    color = colorGrey3,
                    thickness = 0.5.dp
                )
                Spacer(modifier = Modifier.height(defaultPadding*3/2))
                SearchBar(modifier = Modifier.padding(horizontal = defaultPadding))
                Spacer(modifier = Modifier.height(defaultPadding*3/2))
            }
            items(chatList.size){
                ChatTile(
                    chatInfo = chatList[it],
                ){

                }
            }
        }
    }
}
