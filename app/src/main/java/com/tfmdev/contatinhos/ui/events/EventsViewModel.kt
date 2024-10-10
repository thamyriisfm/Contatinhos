package com.tfmdev.contatinhos.ui.events

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.tfmdev.contatinhos.data.local.event.Event
import com.tfmdev.contatinhos.data.local.event.EventRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class EventsViewModel
@Inject constructor(private val eventRepository: EventRepository) : ViewModel() {

    val events: LiveData<List<Event>> =
        eventRepository.allEvents.asLiveData()

    fun insertEvent (event: Event) = viewModelScope.launch {
        eventRepository.insertEvent(event)
    }

    fun updateEvent(event: Event) = viewModelScope.launch {
        eventRepository.updateEvent(event)
    }

    fun deleteEvent(event: Event) = viewModelScope.launch {
        eventRepository.deleteEvent(event)
    }
}