package com.dgd.pmdm_mayo.app

import android.app.Application
import com.dgd.pmdm_mayo.app.di.LocalModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import org.koin.ksp.generated.module

class PmdmApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@PmdmApplication)
            modules(
                LocalModule().module
            )
        }
    }
}