package com.tfmdev.contatinhos.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface ContactDao {

    @Query("SELECT * FROM contact_table ORDER BY isActive DESC, name ASC")
    fun getAlphabetizedWords(): Flow<List<Contact>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(contact: Contact)

    @Update
    suspend fun updateStatusById(contact: Contact)

    @Query("DELETE FROM contact_table")
    suspend fun deleteAll()
}