package com.tfmdev.contatinhos.ui.notifications

import android.os.Bundle
import android.view.View
import com.tfmdev.contatinhos.base.BaseFragment
import com.tfmdev.contatinhos.databinding.FragmentNotificationsBinding

class NotificationsFragment : BaseFragment<FragmentNotificationsBinding>(FragmentNotificationsBinding::inflate) {


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        initCalendar()
    }

    private fun initCalendar() {
        binding.cldView.setOnDateChangeListener { view, year, month, dayOfMonth ->
            binding.tvLabelDateEvent.text = "$dayOfMonth/$month/$year"
        }
    }

}