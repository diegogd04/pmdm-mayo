package com.dgd.pmdm_mayo.features.clientList.domain

interface ClientRepository {

    suspend fun getClientList(): List<Client>
    suspend fun deleteClient(client: Client)
    suspend fun saveClientList(clientList: List<Client>)
}