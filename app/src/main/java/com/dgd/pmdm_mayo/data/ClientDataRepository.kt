package com.dgd.pmdm_mayo.data

import com.dgd.pmdm_mayo.data.local.ClientDbLocalDataSource
import com.dgd.pmdm_mayo.domain.Client
import com.dgd.pmdm_mayo.domain.ClientRepository
import org.koin.core.annotation.Single

@Single
class ClientDataRepository(private val local: ClientDbLocalDataSource) : ClientRepository {

    override suspend fun getClientList(): List<Client> {
        return local.getClientList()
    }

    override suspend fun deleteClient(client: Client) {
        local.deleteClient(client)
    }
}