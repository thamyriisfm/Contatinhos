package com.tfmdev.contatinhos.ui.dashboard

import androidx.fragment.app.viewModels
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.tfmdev.contatinhos.R
import com.tfmdev.contatinhos.base.BaseFragment
import com.tfmdev.contatinhos.databinding.FragmentDashboardBinding

class DashboardFragment :
    BaseFragment<FragmentDashboardBinding>(FragmentDashboardBinding::inflate) {

    private val utilsViewModel: DashboardViewModel by viewModels()

    override fun setupUI() {
        binding.bvDog.setOnClickListener { dogClicked() }
        binding.bvAdvice.setOnClickListener { utilsViewModel.getAdvice() }

    }

    override fun initObservers() {
        utilsViewModel.advice.observe(viewLifecycleOwner) { adviceClicked(it) }
    }

    private fun adviceClicked(advice: String) {
        context?.let {
            MaterialAlertDialogBuilder(it).setTitle(getString(R.string.an_advice_for_you))
                .setMessage(advice).setNeutralButton(getString(R.string.ok), null).create().show()
        }
    }

    private fun dogClicked() {

    }
}