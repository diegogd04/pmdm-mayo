package com.dgd.pmdm_mayo.data.local

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class ClientEntity(

    @PrimaryKey @ColumnInfo(name = "dni") val dni: String,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "email") val email: String
)