package com.dgd.pmdm_mayo.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.dgd.pmdm_mayo.R
import com.dgd.pmdm_mayo.domain.Client

class ClientListAdapter : ListAdapter<Client, ClientListViewHolder>(ClientListDiffUtil()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ClientListViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.view_client_item, parent, false)

        return ClientListViewHolder(view)
    }

    override fun getItemCount(): Int {
        return currentList.size
    }

    override fun onBindViewHolder(holder: ClientListViewHolder, position: Int) {
        holder.bind(currentList[position])
    }
}