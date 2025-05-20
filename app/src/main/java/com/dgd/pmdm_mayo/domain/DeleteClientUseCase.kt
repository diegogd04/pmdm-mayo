package com.dgd.pmdm_mayo.domain

class DeleteClientUseCase(private val repository: ClientRepository) {

    suspend operator fun invoke(client: Client) {
        repository.deleteClient(client)
    }
}