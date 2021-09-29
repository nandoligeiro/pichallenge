package com.picpay.desafio.android.data


import com.picpay.desafio.android.domain.model.User
import javax.inject.Inject

class UserRepository @Inject constructor(private val dataSource: UserDataSource) {

    suspend fun getUsers(): List<User> = dataSource.getUsers()

}
