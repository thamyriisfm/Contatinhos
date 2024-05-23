package com.tfmdev.contatinhos.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.tfmdev.contatinhos.data.local.Contact
import com.tfmdev.contatinhos.databinding.HomeItemBinding

class HomeAdapter(private val listener: AdapterListener)
    : ListAdapter<Contact, HomeViewHolder>(HomeDiffUtill) {

    private var expandedPosition = -1

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        val item = HomeItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return HomeViewHolder(item.root, listener)
    }

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        holder.bind(getItem(position))
        val isExpanded = position == expandedPosition
        holder.binding.fieldSelected.onExpanded(isExpanded)


        holder.binding.fieldSelected.setOnClickListener {
            val previousExpandedPosition = expandedPosition
            expandedPosition = if (isExpanded) -1 else position
            notifyItemChanged(previousExpandedPosition)
            notifyItemChanged(expandedPosition)
        }
    }

    object HomeDiffUtill : DiffUtil.ItemCallback<Contact>() {

        override fun areItemsTheSame(oldItem: Contact, newItem: Contact): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Contact, newItem: Contact): Boolean {
            return oldItem.name == newItem.name && oldItem.phoneNumber == newItem.phoneNumber && oldItem.isActive == newItem.isActive
        }
    }
}

interface AdapterListener {
    fun onEdit(contact: Contact)
    fun onDelete(contact: Contact)
    fun onSwitchChanged(contact: Contact)
    fun onCall(contact: Contact)
    fun onSMS(contact: Contact)
}