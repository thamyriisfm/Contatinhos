package com.tfmdev.contatinhos.ui.new_contact

import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.tfmdev.contatinhos.ContatinhosApplication
import com.tfmdev.contatinhos.base.BaseFragment
import com.tfmdev.contatinhos.data.local.Contact
import com.tfmdev.contatinhos.databinding.FragmentNewContactBinding
import com.tfmdev.contatinhos.ui.home.ContactViewModelFactory
import com.tfmdev.contatinhos.ui.home.HomeViewModel

class NewContactFragment :
    BaseFragment<FragmentNewContactBinding>(FragmentNewContactBinding::inflate) {

    private val homeViewModel: HomeViewModel by activityViewModels {
        ContactViewModelFactory((this.activity?.application as ContatinhosApplication).repository)
    }

    override fun setupUI() {
        binding.mbSave.setOnClickListener { saveContact() }
        binding.etName.addTextChangedListener { verifyFields() }
        binding.rgStatus.setOnCheckedChangeListener { _, _ ->
            verifyFields()
        }
    }

    private fun saveContact() {
        homeViewModel.insert(
            Contact(
                id = "id${binding.etName.text.toString() + binding.etName.length().toString()}",
                name = binding.etName.text.toString(),
                phoneNumber = 12365425,
                isActive = binding.rbActive.isChecked
            )
        )
        findNavController().popBackStack()
    }

    private fun verifyFields() {
        binding.mbSave.isEnabled =
            binding.etName.text?.isNotEmpty() == true
                    && binding.etPhoneNumber.text?.isNotEmpty() == true
    }

}