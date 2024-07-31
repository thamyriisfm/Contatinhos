package com.tfmdev.contatinhos.data.local.event

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Event::class], version = 1, exportSchema = false)
abstract class EventRoomDatabase : RoomDatabase() {

    abstract fun eventDao(): EventDao

}