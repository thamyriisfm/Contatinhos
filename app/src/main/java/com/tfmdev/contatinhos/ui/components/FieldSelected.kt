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

    fun setName(name: String) {
        binding.tvName.text = name
    }

    fun setPhoneNumber(phoneNumber: Long) {
        binding.tvPhoneNumber.text = phoneNumber.toString()
    }

    fun setStatus(status: Boolean) {
        binding.smStatus.isChecked = status
    }
}