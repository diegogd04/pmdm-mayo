package com.dgd.pmdm_mayo.app

import androidx.room.Database
import androidx.room.RoomDatabase
import com.dgd.pmdm_mayo.data.local.ClientDao
import com.dgd.pmdm_mayo.domain.Client

@Database(entities = [Client::class], version = 1)
abstract class PmdmDatabase : RoomDatabase() {

    abstract fun clientDao(): ClientDao
}