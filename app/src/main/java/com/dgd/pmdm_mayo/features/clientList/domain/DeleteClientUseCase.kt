package com.dgd.pmdm_mayo.features.clientList.domain

import org.koin.core.annotation.Single

@Single
class DeleteClientUseCase(private val repository: ClientRepository) {

    suspend operator fun invoke(client: Client) {
        repository.deleteClient(client)
    }
}