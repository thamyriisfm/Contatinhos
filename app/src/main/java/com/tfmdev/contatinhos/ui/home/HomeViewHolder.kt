package com.tfmdev.contatinhos.ui.home

import android.view.View
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.tfmdev.contatinhos.data.local.Contact
import com.tfmdev.contatinhos.databinding.HomeItemBinding

class HomeViewHolder(
    itemView: View,
    private val listener: ((position: Int, isChecked: Boolean) -> Unit)?
) :
    ViewHolder(itemView) {

    private val binding = HomeItemBinding.bind(itemView)

    fun bind(item: Contact) {
        binding.fieldSelected.apply {
            setSwitchChangedListener { _, isChecked ->
                listener?.invoke(adapterPosition, isChecked)
            }
            setName(item.name)
            setPhoneNumber(item.phoneNumber)
            setStatus(item.isActive)
        }

    }
}
