package com.picpay.desafio.android.data.user.repository

import com.picpay.desafio.android.data.user.datasource.UserDataSource
import com.picpay.desafio.android.data.user.mapper.UserDataToDomainMapper
import com.picpay.desafio.android.domain.user.repository.UserRepository
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val dataSource: UserDataSource,
    private val userDataToDomainMapper: UserDataToDomainMapper
) : UserRepository {
    override suspend fun getUsers() = userDataToDomainMapper.toUserDomain(dataSource.getUsers())
}
