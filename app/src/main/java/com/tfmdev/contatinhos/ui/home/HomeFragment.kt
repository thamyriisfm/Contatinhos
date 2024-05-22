package com.tfmdev.contatinhos.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.tfmdev.contatinhos.R
import com.tfmdev.contatinhos.base.BaseFragment
import com.tfmdev.contatinhos.data.local.Contact
import com.tfmdev.contatinhos.databinding.FragmentHomeBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding>(FragmentHomeBinding::inflate) {

    private val homeViewModel: HomeViewModel by activityViewModels()
    private lateinit var homeAdapter: HomeAdapter

    private val adapterListener = object : AdapterListener {
        override fun onEdit(contact: Contact) {
            onEditContact(contact)
        }

        override fun onDelete(contact: Contact) {
            onDeleteClicked(contact)
        }

        override fun onSwitchChanged(contact: Contact) {
            onSwitchChangedClicked(contact)
        }

        override fun onCall(contact: Contact) {
            TODO("Not yet implemented")
        }

        override fun onSMS(contact: Contact) {
            TODO("Not yet implemented")
        }

    }

    override fun setupUI() {
        binding.fabAddContact.setOnClickListener { addContact() }
        binding.rvContactList.adapter = homeAdapter
        homeAdapter.submitList(emptyList())
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        homeAdapter = HomeAdapter(adapterListener)
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun initObservers() {
        homeViewModel.contacts.observe(viewLifecycleOwner) {
            homeAdapter.submitList(homeViewModel.contacts.value)
        }
    }

    private fun addContact() {
        findNavController().navigate(R.id.action_navigation_home_to_newContactFragment)
    }

    private fun onSwitchChangedClicked(contact: Contact) {
        homeViewModel.updateStatus(contact)
    }

    private fun onEditContact(contact: Contact) {
        val attribute = HomeFragmentDirections.actionNavigationHomeToNewContactFragment(contact)
        findNavController().navigate(attribute)
    }

    private fun onDeleteClicked(contact: Contact) {
        context?.let {
            MaterialAlertDialogBuilder(it).setTitle(getString(R.string.title_confirm))
                .setMessage(getString(R.string.message_confirm))
                .setPositiveButton(getString(R.string.yes)) { dialog, wich ->
                    homeViewModel.deleteContact(contact)
                    dialog.dismiss()
                }.setNegativeButton(getString(R.string.not), null).create().show()
        }
    }
}