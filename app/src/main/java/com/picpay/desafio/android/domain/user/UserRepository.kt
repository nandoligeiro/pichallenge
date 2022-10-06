package com.picpay.desafio.android.domain.user

import com.picpay.desafio.android.domain.user.model.User

interface UserRepository {
    suspend fun getUsers(): List<User>
}
