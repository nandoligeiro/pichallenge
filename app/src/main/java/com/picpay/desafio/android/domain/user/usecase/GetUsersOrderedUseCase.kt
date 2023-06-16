package com.picpay.desafio.android.domain.user.usecase

import com.picpay.desafio.android.domain.result.DomainResult
import com.picpay.desafio.android.domain.user.model.UserDomain

interface GetUsersOrderedUseCase {
    suspend fun getOrderedByUserName(): DomainResult<List<UserDomain>>
}
