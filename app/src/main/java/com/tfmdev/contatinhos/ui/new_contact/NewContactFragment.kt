package com.tfmdev.contatinhos.ui.new_contact

import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.tfmdev.contatinhos.base.BaseFragment
import com.tfmdev.contatinhos.data.local.Contact
import com.tfmdev.contatinhos.databinding.FragmentNewContactBinding
import com.tfmdev.contatinhos.ui.home.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NewContactFragment :
    BaseFragment<FragmentNewContactBinding>(FragmentNewContactBinding::inflate) {

    private val homeViewModel: HomeViewModel by activityViewModels()
    private val args: NewContactFragmentArgs by navArgs()

    override fun setupUI() {
        args.contact?.let { onEditMode(it) }
        binding.mbSave.setOnClickListener { saveContact() }
        binding.etName.addTextChangedListener { verifyFields() }
        binding.etPhoneNumber.setListener { verifyFields() }
        binding.rgStatus.setOnCheckedChangeListener { _, _ ->
            verifyFields()
        }
    }

    private fun onEditMode(contact: Contact) {
        binding.etName.setText(contact.name)
        binding.etPhoneNumber.setText(contact.phoneNumber.toString())
        if (contact.isActive) binding.rbActive.isChecked else binding.rbInactive.isChecked
    }

    private fun saveContact() {
        val contact = Contact(
            id = args.contact?.id ?: "id${
                binding.etName.text.toString() + binding.etName.length().toString()
            }",
            name = binding.etName.text.toString(),
            phoneNumber = binding.etPhoneNumber.text.toString(),
            isActive = binding.rbActive.isChecked
        )
        if (args.contact == null) {
            homeViewModel.insert(contact)
        } else {
            homeViewModel.updateStatus(contact)
        }
        findNavController().popBackStack()
    }

    private fun verifyFields() {
        binding.mbSave.isEnabled =
            binding.etName.text?.isNotEmpty() == true && binding.etPhoneNumber.getIsValid()
    }

}