package com.dgd.pmdm_mayo.features.clientList.presentation.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.dgd.pmdm_mayo.databinding.ViewClientItemBinding
import com.dgd.pmdm_mayo.domain.Client

class ClientListViewHolder(
    view: View,
    private val onClickDelete: (Client) -> Unit
) : RecyclerView.ViewHolder(view) {

    private val binding = ViewClientItemBinding.bind(view)

    fun bind(item: Client) {
        binding.apply {
            dni.text = item.dni
            name.text = item.name
            email.text = item.email
            delete.setOnClickListener {
                onClickDelete(item)
            }
        }
    }
}