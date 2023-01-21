package com.picpay.desafio.android.di.hilt

import com.picpay.desafio.android.data.api.datasource.retrofit.RetrofitUserDataSource
import com.picpay.desafio.android.data.repository.user.UserDataSource
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface DataSourceModule {

    @Singleton
    @Binds
    fun bindFinanceDataSource(dataSource: RetrofitUserDataSource): UserDataSource
}