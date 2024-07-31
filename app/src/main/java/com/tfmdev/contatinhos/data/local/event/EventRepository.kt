package com.tfmdev.contatinhos.data.local.event

import androidx.annotation.WorkerThread
import javax.inject.Inject

class EventRepository @Inject constructor(private val eventDao: EventDao) {

    @WorkerThread
    suspend fun insertEvent(event: Event) {
        eventDao.insertEvent(event)
    }

    suspend fun updateEvent(event: Event) {
        eventDao.updateEvent(event)
    }

    suspend fun deleteEvent(event: Event) {
        eventDao.deleteEvent(event)
    }
}