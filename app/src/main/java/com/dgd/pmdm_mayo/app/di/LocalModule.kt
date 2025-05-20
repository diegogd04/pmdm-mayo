package com.dgd.pmdm_mayo.app.di

import android.app.Application
import androidx.room.Room
import com.dgd.pmdm_mayo.app.db.PmdmDatabase
import org.koin.core.annotation.ComponentScan
import org.koin.core.annotation.Module
import org.koin.core.annotation.Single

@Module
@ComponentScan("com.dgd.pmdm_mayo")
class LocalModule {

    @Single
    fun provideDatabase(application: Application): PmdmDatabase {
        return Room.databaseBuilder(
            application,
            PmdmDatabase::class.java,
            "pmdm_database"
        ).build()
    }
}