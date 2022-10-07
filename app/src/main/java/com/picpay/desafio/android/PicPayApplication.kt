package com.picpay.desafio.android

import android.app.Application
import com.picpay.desafio.android.di.koin.appModule
import com.picpay.desafio.android.di.koin.networkModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class PicPayApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@PicPayApplication)
            modules(listOf(appModule, networkModule))
        }
    }
}
