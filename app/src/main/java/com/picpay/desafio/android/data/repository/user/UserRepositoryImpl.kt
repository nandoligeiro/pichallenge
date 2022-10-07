package com.picpay.desafio.android.data.repository.user

import com.picpay.desafio.android.data.api.UserDataSource
import com.picpay.desafio.android.domain.user.UserRepository

class UserRepositoryImpl(private val dataSource: UserDataSource) : UserRepository {

    override suspend fun getUsers() = dataSource.getUsers()
}
