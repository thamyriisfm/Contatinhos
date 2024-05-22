package com.tfmdev.contatinhos.data.local

import androidx.annotation.WorkerThread
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ContactRepository @Inject constructor(private val contactDao: ContactDao) {

    val allContacts: Flow<List<Contact>> = contactDao.getAlphabetizedWords()

    @WorkerThread
    suspend fun insert(contact: Contact) {
        contactDao.insert(contact)
    }

    suspend fun updateStatus(contact: Contact) {
        contactDao.updateStatusById(contact)
    }

    suspend fun deleteContact(contact: Contact) {
        contactDao.deleteContact(contact)
    }
}