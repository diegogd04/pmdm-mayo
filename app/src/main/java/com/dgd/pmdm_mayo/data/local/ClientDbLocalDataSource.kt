package com.dgd.pmdm_mayo.data.local

import android.content.Context
import androidx.room.Room
import com.dgd.pmdm_mayo.app.PmdmDatabase
import com.dgd.pmdm_mayo.domain.Client

class ClientDbLocalDataSource(private val context: Context) {

    private val db = Room.databaseBuilder(
        context,
        PmdmDatabase::class.java,
        "pmdm-database"
    ).build()

    fun getClientList(): List<Client> {
        return db.clientDao().getAll()
    }
}