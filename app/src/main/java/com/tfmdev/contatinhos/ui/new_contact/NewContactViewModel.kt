package com.tfmdev.contatinhos.ui.new_contact

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.tfmdev.contatinhos.data.local.contact.Contact

class NewContactViewModel : ViewModel() {

    val contact = MutableLiveData<Contact>()

    fun saveContact() {}

}