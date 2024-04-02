package com.tfmdev.contatinhos.ui.new_contact

import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.activityViewModels
import com.tfmdev.contatinhos.base.BaseFragment
import com.tfmdev.contatinhos.data.local.Contact
import com.tfmdev.contatinhos.databinding.FragmentNewContactBinding

class NewContactFragment :
    BaseFragment<FragmentNewContactBinding>(FragmentNewContactBinding::inflate) {

    private val newContactViewModel: NewContactViewModel by activityViewModels()

    override fun setupUI() {
        binding.mbSave.setOnClickListener { newContactViewModel.saveContact() }
        binding.etName.addTextChangedListener { verifyFields() }
        //binding.etPhoneNumber.addTextChangedListener { NumberTextWatcher(it.toString()) }
        binding.rgStatus.setOnClickListener { verifyFields() }

    }

    private fun verifyFields() {
/*        if (binding.etName.text?.isNotEmpty() == true
            && checkPhoneNumber()
        ) {
            newContactViewModel.contact.postValue(
                Contact(
                    id = "1235",
                    name = binding.etName.text.toString(),
                    phoneNumber = binding.etPhoneNumber.text.toString().toLong(),
                    isActive = binding.rbActive.isChecked
                )
            )
            binding.mbSave.isEnabled = true
        }*/
    }

    private fun checkPhoneNumber(): Boolean {
        return true
    }

}