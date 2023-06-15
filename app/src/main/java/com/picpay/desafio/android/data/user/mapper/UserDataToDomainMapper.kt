package com.picpay.desafio.android.data.user.mapper

import com.picpay.desafio.android.data.user.model.UserData
import com.picpay.desafio.android.domain.user.model.UserDomain

class UserDataToDomainMapper {

    fun toUserDomain(dataUsers: List<UserData>) = dataUsers.map { input ->
        UserDomain(
            id = input.id,
            img = input.img,
            name = input.name,
            username = input.username
        )
    }
}
