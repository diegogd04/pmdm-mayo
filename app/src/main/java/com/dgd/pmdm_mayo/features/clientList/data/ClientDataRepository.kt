package com.dgd.pmdm_mayo.features.clientList.data

import com.dgd.pmdm_mayo.features.clientList.data.local.db.ClientDbLocalDataSource
import com.dgd.pmdm_mayo.features.clientList.domain.Client
import com.dgd.pmdm_mayo.features.clientList.domain.ClientRepository
import org.koin.core.annotation.Single

@Single
class ClientDataRepository(private val local: ClientDbLocalDataSource) : ClientRepository {

    override suspend fun getClientList(): List<Client> {
        return local.getClientList()
    }

    override suspend fun deleteClient(client: Client) {
        local.deleteClient(client)
    }

    override suspend fun saveClientList(clientList: List<Client>) {
        local.saveClientList(clientList)
    }

    override suspend fun saveClient(client: Client) {
        local.saveClient(client)
    }
}