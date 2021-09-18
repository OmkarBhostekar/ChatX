package com.omkarcodes.chatx.presentation.model

data class TopBarAction(
    val icon: Int,
    val desc: String? = null,
    val onClick: () -> Unit
)
