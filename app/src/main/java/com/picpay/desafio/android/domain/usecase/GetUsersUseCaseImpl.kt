package com.picpay.desafio.android.domain.usecase

import com.picpay.desafio.android.data.UserRepository
import com.picpay.desafio.android.domain.model.User


class GetUsersUseCaseImpl(private val userRepository: UserRepository): GetUsersUseCase {

    override suspend operator fun invoke(): List<User> {
        return userRepository.getUsers()
    }
}