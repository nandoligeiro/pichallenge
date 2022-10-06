package com.picpay.desafio.android.data.api

import com.picpay.desafio.android.data.response.user.UserResponse


interface UserDataSource {
    suspend fun getUsers(): List<UserResponse>
}
