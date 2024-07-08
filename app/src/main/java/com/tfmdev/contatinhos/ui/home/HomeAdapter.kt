package com.tfmdev.contatinhos.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.tfmdev.contatinhos.data.local.Contact
import com.tfmdev.contatinhos.databinding.HomeItemBinding

class HomeAdapter(private val listener: AdapterListener)
    : ListAdapter<Contact, HomeViewHolder>(HomeDiffUtill) {

    private var expandedPositionId: Int? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        val item = HomeItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return HomeViewHolder(item.root, listener)
    }

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)

        val isExpandedId = item.id == expandedPositionId
        holder.binding.fieldSelected.onExpanded(isExpandedId)


        holder.binding.fieldSelected.setOnClickListener {
            val previousExpandedPositionId = expandedPositionId
            expandedPositionId = if (isExpandedId) null else item.id
            notifyItemChanged(getPositionForItemId(previousExpandedPositionId))
            notifyItemChanged(position)
        }
    }

    private fun getPositionForItemId(itemId: Int?): Int {
        return currentList.indexOfFirst { it.id == itemId }
    }

    object HomeDiffUtill : DiffUtil.ItemCallback<Contact>() {

        override fun areItemsTheSame(oldItem: Contact, newItem: Contact): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Contact, newItem: Contact): Boolean {
            return oldItem == newItem
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