package com.dgd.pmdm_mayo.features.clientList.data.local.db

import com.dgd.pmdm_mayo.features.clientList.domain.Client


fun ClientEntity.toModel(): Client {
    return Client(this.dni, this.name, this.email)
}

fun Client.toEntity(): ClientEntity {
    return ClientEntity(this.dni, this.name, this.email)
}