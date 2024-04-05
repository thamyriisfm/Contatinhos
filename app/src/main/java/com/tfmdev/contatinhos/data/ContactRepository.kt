package com.tfmdev.contatinhos.data

import androidx.annotation.WorkerThread
import com.tfmdev.contatinhos.data.local.Contact
import com.tfmdev.contatinhos.data.local.ContactDao
import kotlinx.coroutines.flow.Flow

class ContactRepository(private val contactDao: ContactDao) {

    val allContacts: Flow<List<Contact>> = contactDao.getAlphabetizedWords()

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun insert(contact: Contact) {
        contactDao.insert(contact)
    }
}