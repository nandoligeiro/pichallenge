package com.picpay.desafio.android.data.repository.user

import com.picpay.desafio.android.domain.user.UserRepository
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val dataSource: UserDataSource) : UserRepository {

    override suspend fun getUsers() = dataSource.getUsers()
}
