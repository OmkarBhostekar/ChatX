package com.omkarcodes.chatx.comman

import androidx.compose.ui.unit.dp
import com.omkarcodes.chatx.R
import com.omkarcodes.chatx.presentation.model.*

object Constants {

    val defaultPadding = 12.dp
    const val USER_ID = 1

    val storiesList = listOf(
        Story(R.drawable.avatar_2,"Prathmesh",false),
        Story(R.drawable.avatar_1,"Saurabh",true),
        Story(R.drawable.avatar_5,"Mahesh",false),
        Story(R.drawable.avatar_4,"Akash",false),
        Story(R.drawable.avatar_2,"Nehal",false),
        Story(R.drawable.avatar_3,"Pushkaraj",false),
        Story(R.drawable.avatar_7,"Tejas",false),
        Story(R.drawable.avatar_2,"Sanket",false),
    )

    val chatList = listOf(
        ChatInfo("Saurabh", R.drawable.avatar_1,true,"Did you complete homework?","2h",1),
        ChatInfo("Prathmesh", R.drawable.avatar_2,false,"You should watch tokyo revengers, it's awesome","3h",3),
        ChatInfo("Akash", R.drawable.avatar_4,true,"You: available for wild rift?","6h",0),
    )

    val contactList = listOf(
        ContactInfo("Akash",R.drawable.avatar_4,false,"Last seen 2 hours ago"),
        ContactInfo("Aniket",R.drawable.avatar_7,false,"Last seen 39 minutes ago"),
        ContactInfo("Mahesh",R.drawable.avatar_5,true,"Online"),
        ContactInfo("Nehal",R.drawable.avatar_2,true,"Online"),
        ContactInfo("Omkar",R.drawable.avatar_1,false,"Last seen 15 minutes ago"),
        ContactInfo("Pushkaraj",R.drawable.avatar_3,false,"Last seen 2 minutes ago"),
        ContactInfo("Prathemesh",R.drawable.avatar_2,true,"Online"),
        ContactInfo("Sanket",R.drawable.avatar_2,false,"Last seen yesterday"),
        ContactInfo("Saurabh",R.drawable.avatar_1,true,"Online"),
        ContactInfo("Tejas",R.drawable.avatar_7,true,"Online"),
    )

    val chatMessages = listOf(
        Message(text = "Hello Omkar",time = "17:10", date = "Sat, 18/09",status = "Read",senderId = 2),
        Message(text = "Hello Saurabh, How are you?",time = "17:19", date = "Sat, 18/09",status = "Read",senderId = 1),
        Message(text = "I'm fine, Did you complete assignment?",time = "17:20", date = "Sat, 18/09",status = "Read",senderId = 2),
        Message(text = "Yeah, just a while ago",time = "17:21", date = "Sat, 18/09",status = "Read",senderId = 1,repliedMessage = RepliedMessage("I'm fine, Did you complete assignment?",senderId = 2)),
        Message(text = "Can you send me last problem solution?",time = "17:22", date = "Sat, 18/09",status = "Read",senderId = 2, repliedMessage = RepliedMessage("Yeah, just a while ago",senderId = 1)),
        Message(text = "Sure, wait a minute",time = "17:22", date = "Sat, 18/09",status = "Read",senderId = 1),
        Message(image = R.drawable.assignment,time = "17:24", date = "Sat, 18/09",status = "Read",senderId = 1),
        Message(text = "Thank you so much",time = "17:27", date = "Sat, 18/09",status = "Read",senderId = 2),
        Message(text = "No problem",time = "17:28", date = "Sat, 18/09",status = "Read",senderId = 1),
        Message(text = "Available for Wild Rift?",time = "12:15", date = "Sat, 19/09",status = "Read",senderId = 1),
    ).asReversed()
}