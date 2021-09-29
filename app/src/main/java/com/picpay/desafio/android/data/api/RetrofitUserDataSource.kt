package com.picpay.desafio.android.data.api

import com.picpay.desafio.android.data.UserDataSource
import com.picpay.desafio.android.domain.model.User

class RetrofitUserDataSource constructor(
    private val picPayService: PicPayService
) : UserDataSource {
    override suspend fun getUsers(): List<User> = picPayService.getUsers()
}
