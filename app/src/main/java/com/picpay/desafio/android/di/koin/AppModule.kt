package com.picpay.desafio.android.di.koin

import com.picpay.desafio.android.data.api.UserDataSource
import com.picpay.desafio.android.data.repository.user.UserRepositoryImpl
import com.picpay.desafio.android.data.api.datasource.retrofit.RetrofitUserDataSource
import com.picpay.desafio.android.domain.user.UserRepository
import com.picpay.desafio.android.domain.user.usecase.GetUsersUseCase
import com.picpay.desafio.android.domain.user.usecase.GetUsersUseCaseImpl
import com.picpay.desafio.android.presentation.main.viewmodel.MainViewModel
import org.koin.dsl.module

val appModule = module {
    factory<UserDataSource> { RetrofitUserDataSource(get()) }
    factory <UserRepository>{ UserRepositoryImpl(get()) }
    factory<GetUsersUseCase> { GetUsersUseCaseImpl(get()) }
    factory { MainViewModel(get()) }
}

