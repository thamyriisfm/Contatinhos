package com.tfmdev.contatinhos.ui.components

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.CompoundButton
import android.widget.LinearLayout
import androidx.core.view.isVisible
import com.tfmdev.contatinhos.databinding.FieldSelectedViewBinding

class FieldSelected(context: Context, attrs: AttributeSet) : LinearLayout(context, attrs) {

    private val binding = FieldSelectedViewBinding.inflate(LayoutInflater.from(context), this, true)
    private var isExpandable = false

    init {
        setOnClickListener {
            isExpandable = !isExpandable
            binding.viewExpandable.isVisible = isExpandable
        }
    }

    fun setSwitchChangedListener(listener: CompoundButton.OnCheckedChangeListener) {
        binding.smStatus.setOnCheckedChangeListener(listener)
    }

    fun onEditClicked(listener: () -> Unit) {
        binding.fabEdit.setOnClickListener { listener.invoke() }
    }

    fun onDeleteClicked(listener: () -> Unit) {
        binding.fabDelete.setOnClickListener { listener.invoke() }
    }

    fun onCallClicked(listener: () -> Unit) {
        binding.fabCall.setOnClickListener { listener.invoke() }
    }

    fun onSmsClicked(listener: () -> Unit) {
        binding.fabSms.setOnClickListener { listener.invoke() }
    }

    fun setName(name: String) {
        binding.tvName.text = name
    }

    fun setPhoneNumber(phoneNumber: String) {
        binding.tvPhoneNumber.text = phoneNumber
    }

    fun setStatus(status: Boolean) {
        binding.smStatus.isChecked = status
    }
}