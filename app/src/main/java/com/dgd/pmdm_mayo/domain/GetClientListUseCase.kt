package com.dgd.pmdm_mayo.domain

class GetClientListUseCase(private val repository: ClientRepository) {

    suspend operator fun invoke(): List<Client> {
        return repository.getClientList()
    }
}