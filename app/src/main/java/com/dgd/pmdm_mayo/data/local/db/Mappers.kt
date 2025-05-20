package com.dgd.pmdm_mayo.data.local.db

import com.dgd.pmdm_mayo.domain.Client

fun ClientEntity.toModel(): Client {
    return Client(this.dni, this.name, this.email)
}

fun Client.toEntity(): ClientEntity {
    return ClientEntity(this.dni, this.name, this.email)
}