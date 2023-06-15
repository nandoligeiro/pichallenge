package com.picpay.desafio.android.di.hilt

import com.picpay.desafio.android.data.user.repository.UserRepositoryImpl
import com.picpay.desafio.android.domain.user.repository.UserRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
interface RepositoryModule {

    @Binds
    fun bindUserRepository(repository: UserRepositoryImpl): UserRepository

}