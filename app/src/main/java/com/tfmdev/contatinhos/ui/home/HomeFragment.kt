package com.tfmdev.contatinhos.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.tfmdev.contatinhos.ContatinhosApplication
import com.tfmdev.contatinhos.R
import com.tfmdev.contatinhos.base.BaseFragment
import com.tfmdev.contatinhos.data.local.Contact
import com.tfmdev.contatinhos.databinding.FragmentHomeBinding

class HomeFragment : BaseFragment<FragmentHomeBinding>(FragmentHomeBinding::inflate) {

    private val homeViewModel: HomeViewModel by activityViewModels {
        ContactViewModelFactory((this.activity?.application as ContatinhosApplication).repository)
    }
    private lateinit var homeAdapter: HomeAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        homeAdapter = HomeAdapter { contact ->
            onClick(contact)
        }
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    private fun onClick(contact: Contact) {
        contact.apply { this.isActive = !this.isActive }
        homeViewModel.updateStatus(contact)
    }

    override fun setupUI() {
        binding.fabAddContact.setOnClickListener { addContact() }
        binding.rvContactList.adapter = homeAdapter
        homeAdapter.submitList(emptyList())
    }

    private fun addContact() {
        findNavController().navigate(R.id.action_navigation_home_to_newContactFragment)
    }

    override fun initObservers() {
        homeViewModel.contacts.observe(viewLifecycleOwner) {
            homeAdapter.submitList(homeViewModel.contacts.value)
        }
    }
}