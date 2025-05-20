package com.dgd.pmdm_mayo.features.clientList.domain

import org.koin.core.annotation.Single

@Single
data class Client(
    var dni: String,
    var name: String,
    var email: String
)