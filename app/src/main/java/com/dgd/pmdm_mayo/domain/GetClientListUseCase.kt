package com.dgd.pmdm_mayo.domain

import org.koin.core.annotation.Single

@Single
class GetClientListUseCase(private val repository: ClientRepository) {

    suspend operator fun invoke(): List<Client> {
        return repository.getClientList()
    }
}