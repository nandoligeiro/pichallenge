package com.picpay.desafio.android.di.hilt

import com.picpay.desafio.android.data.user.datasource.UserDataSource
import com.picpay.desafio.android.datasource.user.datasource.UserDataSourceImpl
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
    fun bindUserDataSource(dataSource: UserDataSourceImpl): UserDataSource
}