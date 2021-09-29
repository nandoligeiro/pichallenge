package com.picpay.desafio.android.di

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.picpay.desafio.android.data.api.PicPayService
import okhttp3.OkHttpClient
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


val networkModule = module {
    single { okHttp }
    single { service }
    single { retrofit }
}

private const val url = "https://609a908e0f5a13001721b74e.mockapi.io/picpay/api/"

private val gson: Gson by lazy { GsonBuilder().create() }

private val okHttp: OkHttpClient by lazy {
    OkHttpClient.Builder()
        .build()
}

private val retrofit: Retrofit by lazy {
    Retrofit.Builder()
        .baseUrl(url)
        .client(okHttp)
        .addConverterFactory(GsonConverterFactory.create(gson))
        .build()
}

private val service: PicPayService by lazy {
    retrofit.create(PicPayService::class.java)
}
