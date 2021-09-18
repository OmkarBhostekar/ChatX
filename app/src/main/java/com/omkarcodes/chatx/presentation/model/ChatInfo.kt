package com.omkarcodes.chatx.presentation.model

data class ChatInfo(
    val name: String,
    val image: Int,
    val isOnline: Boolean,
    val lastMessage: String,
    val msgTime: String,
    val unreadMsgCount: Int,
)
