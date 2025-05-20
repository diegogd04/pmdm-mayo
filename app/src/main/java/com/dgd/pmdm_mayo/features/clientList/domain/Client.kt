package com.dgd.pmdm_mayo.features.clientList.domain

import org.koin.core.annotation.Single

@Single
data class Client(
    val dni: String,
    val name: String,
    val email: String
)