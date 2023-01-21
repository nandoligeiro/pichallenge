package com.picpay.desafio.android.domain.user.model

import com.picpay.desafio.android.presentation.main.model.UiUser

data class User(
    val img: String,
    val name: String,
    val id: Int,
    val username: String
)
fun User.toUiUser() = UiUser(
    img = this.img,
    name = this.name,
    username = this.username
)