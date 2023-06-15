package com.picpay.desafio.android.domain.user.usecase

import com.picpay.desafio.android.domain.user.repository.UserRepository
import javax.inject.Inject

class GetUsersOrderedUseCaseImpl @Inject constructor(
    private val userRepository: UserRepository
) : GetUsersOrderedUseCase {

    override suspend fun getOrderedByUserName() = userRepository.getUsers().sortedBy { it.username }
}
