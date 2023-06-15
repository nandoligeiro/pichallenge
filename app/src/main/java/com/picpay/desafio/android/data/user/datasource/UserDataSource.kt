package com.picpay.desafio.android.data.user.datasource

import com.picpay.desafio.android.data.user.model.UserData

interface UserDataSource {
    suspend fun getUsers(): List<UserData>
}
