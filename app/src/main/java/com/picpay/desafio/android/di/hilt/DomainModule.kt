package com.picpay.desafio.android.di.hilt

import com.picpay.desafio.android.domain.user.usecase.GetUsersUseCase
import com.picpay.desafio.android.domain.user.usecase.GetUsersUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
interface DomainModule {

    @Binds
    fun bindGetFinanceUseCase(useCase: GetUsersUseCaseImpl): GetUsersUseCase

}