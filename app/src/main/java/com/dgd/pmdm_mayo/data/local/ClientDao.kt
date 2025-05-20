package com.dgd.pmdm_mayo.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.dgd.pmdm_mayo.domain.Client

@Dao
interface ClientDao {

    @Query("SELECT * FROM cliententity")
    fun getAll(): List<Client>

    @Query("SELECT * FROM cliententity WHERE dni LIKE dni")
    fun findByDni(dni: String): Client

    @Insert
    fun insertAll(vararg clients: Client)
}