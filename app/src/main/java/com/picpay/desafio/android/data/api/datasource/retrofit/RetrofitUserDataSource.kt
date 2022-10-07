package com.picpay.desafio.android.data.api.datasource.retrofit

import com.picpay.desafio.android.data.api.PicPayService
import com.picpay.desafio.android.data.api.UserDataSource
import com.picpay.desafio.android.data.response.user.toUser
import com.picpay.desafio.android.domain.user.model.User

class RetrofitUserDataSource constructor(
    private val picPayService: PicPayService
) : UserDataSource {
    override suspend fun getUsers(): List<User> = picPayService.getUsers().map {
        it.toUser()
    }
}
