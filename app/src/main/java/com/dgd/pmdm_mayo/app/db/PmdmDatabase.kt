package com.dgd.pmdm_mayo.app.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.dgd.pmdm_mayo.data.local.db.ClientDao
import com.dgd.pmdm_mayo.data.local.db.ClientEntity

@Database(entities = [ClientEntity::class], version = 1)
abstract class PmdmDatabase : RoomDatabase() {

    abstract fun clientDao(): ClientDao
}