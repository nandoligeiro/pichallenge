package com.picpay.desafio.android.domain.user.usecase

import com.picpay.desafio.android.domain.user.model.User

interface GetUsersUseCase {
    suspend operator fun invoke(): List<User>
    suspend fun getOrderByUserName(): List<User>
}