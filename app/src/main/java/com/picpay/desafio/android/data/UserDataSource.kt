package com.picpay.desafio.android.data

import com.picpay.desafio.android.domain.model.User


interface UserDataSource {
    suspend fun getUsers(): List<User>
}
