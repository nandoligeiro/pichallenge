package com.picpay.desafio.android.di.hilt

import com.picpay.desafio.android.domain.user.usecase.GetUsersOrderedUseCase
import com.picpay.desafio.android.domain.user.usecase.GetUsersOrderedUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
interface UseCaseModule {

    @Binds
    fun bindGetUsersOrderedUseCase(useCase: GetUsersOrderedUseCaseImpl): GetUsersOrderedUseCase
}