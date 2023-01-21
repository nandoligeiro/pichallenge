package com.picpay.desafio.android.domain.user.usecase

import com.picpay.desafio.android.domain.user.UserRepository
import javax.inject.Inject

class GetUsersUseCaseImpl @Inject constructor(private val userRepository: UserRepository) : GetUsersUseCase {

    override suspend operator fun invoke() = try {
        userRepository.getUsers()
    } catch (e: Exception) {
        listOf()
    }

    override suspend fun getOrderByUserName() = userRepository.getUsers().sortedBy { it.username }
}
