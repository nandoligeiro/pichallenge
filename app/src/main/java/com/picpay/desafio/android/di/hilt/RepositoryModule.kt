package com.picpay.desafio.android.di.hilt

import com.picpay.desafio.android.data.repository.user.UserRepositoryImpl
import com.picpay.desafio.android.domain.user.UserRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
interface RepositoryModule {

    @Binds
    fun bindFinanceRepository(repository: UserRepositoryImpl): UserRepository

}