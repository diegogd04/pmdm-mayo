package com.dgd.pmdm_mayo.presentation.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.dgd.pmdm_mayo.databinding.ViewClientItemBinding
import com.dgd.pmdm_mayo.domain.Client

class ClientListViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val binding = ViewClientItemBinding.bind(view)

    fun bind(item: Client) {
        binding.apply {
            dni.text = item.dni
            name.text = item.name
            email.text = item.email
            delete.setOnClickListener {

            }
        }
    }
}