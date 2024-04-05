package com.tfmdev.contatinhos.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.tfmdev.contatinhos.data.local.Contact
import com.tfmdev.contatinhos.databinding.HomeItemBinding

class HomeAdapter() :
    ListAdapter<Contact, HomeViewHolder>(HomeDiffUtill) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        val item = HomeItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return HomeViewHolder(item.root)
    }

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    object HomeDiffUtill : DiffUtil.ItemCallback<Contact>() {

        override fun areItemsTheSame(oldItem: Contact, newItem: Contact): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Contact, newItem: Contact): Boolean {
            return oldItem.name == newItem.name
                    && oldItem.phoneNumber == newItem.phoneNumber
                    && oldItem.isActive == newItem.isActive
        }
    }
}