package com.dgd.pmdm_mayo.data.local

import com.dgd.pmdm_mayo.app.db.PmdmDatabase
import com.dgd.pmdm_mayo.domain.Client
import org.koin.core.annotation.Single

@Single
class ClientDbLocalDataSource(private val db: PmdmDatabase) {

    fun getClientList(): List<Client> {
        return db.clientDao().getAll()
    }

    fun deleteClient(client: Client) {
        db.clientDao().delete(client)
    }
}