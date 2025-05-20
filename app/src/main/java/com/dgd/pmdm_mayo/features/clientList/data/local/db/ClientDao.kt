package com.dgd.pmdm_mayo.features.clientList.data.local.db

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface ClientDao {

    @Query("SELECT * FROM clients")
    fun getAll(): List<ClientEntity>

    @Query("SELECT * FROM clients WHERE dni LIKE :dni")
    fun findByDni(dni: String): ClientEntity

    @Insert
    fun insertAll(vararg clients: ClientEntity)

    @Insert
    fun insert(client: ClientEntity)

    @Delete
    fun delete(client: ClientEntity)
}