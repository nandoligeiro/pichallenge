package com.picpay.desafio.android.presentation.main.mapper

import com.picpay.desafio.android.domain.user.model.UserDomain
import com.picpay.desafio.android.presentation.main.model.UiUser

class UserDomainToUiMapper {

    fun toUiUser(userDomains: List<UserDomain>) = userDomains.map { input ->
        UiUser(
            img = input.img,
            name = input.name,
            username = input.username
        )
    }
}
