package com.dgd.pmdm_mayo.domain

interface ClientRepository {

    suspend fun getClientList(): List<Client>
    suspend fun deleteClient(client: Client)
}