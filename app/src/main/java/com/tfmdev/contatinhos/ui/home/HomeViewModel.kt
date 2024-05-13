package com.tfmdev.contatinhos.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.tfmdev.contatinhos.data.local.Contact
import com.tfmdev.contatinhos.data.local.ContactRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val repository: ContactRepository) : ViewModel() {

    val contacts: LiveData<List<Contact>> = repository.allContacts.asLiveData()

    fun insert(contact: Contact) = viewModelScope.launch {
        repository.insert(contact)
    }

    fun updateStatus(contact: Contact) = viewModelScope.launch {
        repository.updateStatus(contact)
    }
}