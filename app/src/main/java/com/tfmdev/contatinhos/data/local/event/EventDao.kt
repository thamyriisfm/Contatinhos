package com.tfmdev.contatinhos.data.local.event

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update

@Dao
interface EventDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertEvent(event: Event)

    @Update
    suspend fun updateEvent(event: Event)

    @Delete
    suspend fun deleteEvent(event: Event)

    @Query("DELETE FROM event_table")
    suspend fun deleteAll()
}