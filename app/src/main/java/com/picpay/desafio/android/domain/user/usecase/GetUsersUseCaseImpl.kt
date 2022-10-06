package com.picpay.desafio.android.domain.user.usecase

import com.picpay.desafio.android.domain.user.UserRepository

class GetUsersUseCaseImpl(private val userRepository: UserRepository) : GetUsersUseCase {

    override suspend operator fun invoke() = try {
        userRepository.getUsers()
    } catch (e: Exception) {
        listOf()
    }
}
