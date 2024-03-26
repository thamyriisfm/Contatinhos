package com.tfmdev.contatinhos.ui.home

import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.tfmdev.contatinhos.R
import com.tfmdev.contatinhos.base.BaseFragment
import com.tfmdev.contatinhos.databinding.FragmentHomeBinding

class HomeFragment : BaseFragment<FragmentHomeBinding>(FragmentHomeBinding::inflate) {

    private val homeViewModel: HomeViewModel by activityViewModels()
    override fun setupUI() {
        binding.fabAddContact.setOnClickListener { addContact() }
    }

    private fun addContact() {
        findNavController().navigate(R.id.action_navigation_home_to_newContactFragment)
    }

    override fun initObservers() {
        homeViewModel.text.observe(viewLifecycleOwner) {
        }
    }
}