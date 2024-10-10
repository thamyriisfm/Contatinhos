package com.tfmdev.contatinhos.ui.events

import android.os.Bundle
import android.view.View
import androidx.fragment.app.activityViewModels
import com.tfmdev.contatinhos.base.BaseFragment
import com.tfmdev.contatinhos.databinding.FragmentNotificationsBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class EventsFragment : BaseFragment<FragmentNotificationsBinding>(FragmentNotificationsBinding::inflate) {

    private val eventViewModel: EventsViewModel by activityViewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        initCalendar()
    }

    private fun saveEvent() {}

    private fun initCalendar() {
        binding.cldView.setOnDateChangeListener { view, year, month, dayOfMonth ->
            binding.tvLabelDateEvent.text = "$dayOfMonth/$month/$year"
        }
    }

}