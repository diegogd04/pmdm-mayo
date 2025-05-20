package com.dgd.pmdm_mayo.features.clientList.data.local.db

import com.dgd.pmdm_mayo.app.db.PmdmDatabase
import com.dgd.pmdm_mayo.domain.Client
import org.koin.core.annotation.Single

@Single
class ClientDbLocalDataSource(private val db: PmdmDatabase) {

    fun getClientList(): List<Client> {
        return db.clientDao().getAll().map { it.toModel() }
    }

    fun deleteClient(client: Client) {
        db.clientDao().delete(client.toEntity())
    }

    fun saveClientList(clientList: List<Client>) {
        db.clientDao().insertAll(*clientList.map { it.toEntity() }.toTypedArray())
    }
}