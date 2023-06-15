package com.picpay.desafio.android.datasource.user.datasource

import com.picpay.desafio.android.data.api.PicPayService
import com.picpay.desafio.android.data.user.datasource.UserDataSource
import com.picpay.desafio.android.data.user.model.UserData
import com.picpay.desafio.android.datasource.user.mapper.UserEntityToDataMapper
import javax.inject.Inject

class UserDataSourceImpl @Inject constructor(
    private val picPayService: PicPayService,
    private val userEntityToDataMapper: UserEntityToDataMapper
) : UserDataSource {
    override suspend fun getUsers():
            List<UserData> = userEntityToDataMapper.toUserData(picPayService.getUsers())
}
