package com.dgd.pmdm_mayo.features.clientList.presentation.adapter

import androidx.recyclerview.widget.DiffUtil
import com.dgd.pmdm_mayo.domain.Client

class ClientListDiffUtil : DiffUtil.ItemCallback<Client>() {

    override fun areItemsTheSame(oldItem: Client, newItem: Client): Boolean {
        return oldItem.dni == newItem.dni
    }

    override fun areContentsTheSame(oldItem: Client, newItem: Client): Boolean {
        return oldItem == newItem
    }
}