package com.picpay.desafio.android.di

import com.picpay.desafio.android.data.UserDataSource
import com.picpay.desafio.android.data.UserRepository
import com.picpay.desafio.android.data.api.RetrofitUserDataSource
import com.picpay.desafio.android.domain.usecase.GetUsersUseCase
import com.picpay.desafio.android.domain.usecase.GetUsersUseCaseImpl
import com.picpay.desafio.android.presentation.MainViewModel
import org.koin.dsl.module

val appModule = module {
    factory<UserDataSource> { RetrofitUserDataSource(get()) }
    factory { UserRepository(get()) }
    factory<GetUsersUseCase> { GetUsersUseCaseImpl(get()) }
    factory { MainViewModel(get()) }
}

