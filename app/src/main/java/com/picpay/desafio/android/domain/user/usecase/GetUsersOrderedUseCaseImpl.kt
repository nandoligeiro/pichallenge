package com.picpay.desafio.android.domain.user.usecase

import com.picpay.desafio.android.di.hilt.IoDispatcher
import com.picpay.desafio.android.domain.result.DomainResult
import com.picpay.desafio.android.domain.user.repository.UserRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import javax.inject.Inject

class GetUsersOrderedUseCaseImpl @Inject constructor(
    private val userRepository: UserRepository,
    @IoDispatcher private val ioDispatcher: CoroutineDispatcher
) : GetUsersOrderedUseCase {
    override suspend fun getOrderedByUserName() = withContext(ioDispatcher) {

        try {
            DomainResult.Success(userRepository.getUsers().sortedBy { it.username })
        } catch (e: Exception) {
            DomainResult.Error(IllegalStateException("${e.message}"))
        }
    }
}
