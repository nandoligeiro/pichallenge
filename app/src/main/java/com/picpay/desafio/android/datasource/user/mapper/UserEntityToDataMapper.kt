package com.picpay.desafio.android.datasource.user.mapper

import com.picpay.desafio.android.data.user.model.UserData
import com.picpay.desafio.android.datasource.user.entity.UserEntity

class UserEntityToDataMapper {
    fun toUserData(entityUsers: List<UserEntity>) = entityUsers.map { input ->
        UserData(
            id = input.id,
            img = input.img,
            name = input.name,
            username = input.username
        )
    }
}
