package com.dgd.pmdm_mayo.domain

import org.koin.core.annotation.Single

@Single
data class Client(
    val dni: String,
    val name: String,
    val email: String
)