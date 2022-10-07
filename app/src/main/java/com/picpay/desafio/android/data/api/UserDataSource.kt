package com.picpay.desafio.android.data.api

import com.picpay.desafio.android.domain.user.model.User

interface UserDataSource {
    suspend fun getUsers(): List<User>
}
