package com.dgd.pmdm_mayo.features.clientList.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.dgd.pmdm_mayo.R
import com.dgd.pmdm_mayo.features.clientList.domain.Client

class ClientListAdapter(
    private val onDeleteClick: (Client) -> Unit
) : ListAdapter<Client, ClientListViewHolder>(com.dgd.pmdm_mayo.features.clientList.presentation.adapter.ClientListDiffUtil()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ClientListViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.view_client_item, parent, false)

        return ClientListViewHolder(view, onDeleteClick)
    }

    override fun getItemCount(): Int {
        return currentList.size
    }

    override fun onBindViewHolder(holder: ClientListViewHolder, position: Int) {
        holder.bind(currentList[position])
    }
}