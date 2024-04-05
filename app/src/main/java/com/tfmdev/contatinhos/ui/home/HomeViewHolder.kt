package com.tfmdev.contatinhos.ui.home

import android.view.View
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.tfmdev.contatinhos.data.local.Contact
import com.tfmdev.contatinhos.databinding.HomeItemBinding

class HomeViewHolder(itemView: View) : ViewHolder(itemView) {
    private val binding = HomeItemBinding.bind(itemView)

    fun bind(item: Contact) {
        binding.tvName.text = item.name
    }
}
