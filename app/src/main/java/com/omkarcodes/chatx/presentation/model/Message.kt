package com.omkarcodes.chatx.presentation.model

data class Message(
    val text: String? = null,
    val image: Int? = null,
    val time: String,
    val date: String,
    val status: String,
    val senderId: Int,
    val repliedMessage: RepliedMessage? = null,
)

data class RepliedMessage(
    val text: String? = null,
    val image: Int? = null,
    val senderId: Int,
)