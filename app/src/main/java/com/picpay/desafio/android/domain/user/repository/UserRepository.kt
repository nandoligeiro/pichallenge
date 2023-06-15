package com.picpay.desafio.android.domain.user.repository

import com.picpay.desafio.android.domain.user.model.UserDomain

interface UserRepository {
    suspend fun getUsers(): List<UserDomain>
}
