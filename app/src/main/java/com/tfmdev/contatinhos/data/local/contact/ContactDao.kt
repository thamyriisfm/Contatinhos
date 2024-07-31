package com.tfmdev.contatinhos.data.local.contact

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface ContactDao {

    @Query("SELECT * FROM contact_table ORDER BY isActive DESC, name COLLATE NOCASE ASC")
    fun getAlphabetizedWords(): Flow<List<Contact>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertContact(contact: Contact)

    @Update
    suspend fun updateStatusById(contact: Contact)

    @Delete
    suspend fun deleteContact(contact: Contact)

    @Query("DELETE FROM contact_table")
    suspend fun deleteAll()
}