package com.picpay.desafio.android.domain.user.usecase

import com.picpay.desafio.android.domain.user.model.UserDomain

interface GetUsersOrderedUseCase {
    suspend fun getOrderedByUserName(): List<UserDomain>
}
