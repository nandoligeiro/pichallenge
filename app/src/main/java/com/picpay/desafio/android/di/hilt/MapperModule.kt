package com.picpay.desafio.android.di.hilt

import com.picpay.desafio.android.data.user.mapper.UserDataToDomainMapper
import com.picpay.desafio.android.datasource.user.mapper.UserEntityToDataMapper
import com.picpay.desafio.android.presentation.main.mapper.UserDomainToUiMapper
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class MapperModule {

    @Provides
    fun providesUserEntityToDataMapper() = UserEntityToDataMapper()

    @Provides
    fun providesUserDataToDomainMapper() = UserDataToDomainMapper()

    @Provides
    fun providesUserDomainToUiMapper() = UserDomainToUiMapper()

}
