package com.picpay.desafio.android.data

import com.picpay.desafio.android.domain.model.User

class UserRepository (private val dataSource: UserDataSource) {

    suspend fun getUsers(): List<User> = dataSource.getUsers()

}
