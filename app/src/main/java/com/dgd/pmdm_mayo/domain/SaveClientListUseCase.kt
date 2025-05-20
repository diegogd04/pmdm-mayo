package com.dgd.pmdm_mayo.domain

import org.koin.core.annotation.Single

@Single
class SaveClientListUseCase(private val repository: ClientRepository) {

    suspend operator fun invoke(clientList: List<Client>) {
        repository.saveClientList(clientList)
    }
}