package com.dgd.pmdm_mayo.features.clientForm.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.dgd.pmdm_mayo.databinding.FragmentClientFormBinding
import com.dgd.pmdm_mayo.features.clientList.domain.Client
import com.dgd.pmdm_mayo.features.clientList.presentation.ClientListViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class ClientFormFragment : Fragment() {

    private var _binding: FragmentClientFormBinding? = null
    private val binding get() = _binding!!
    private val viewModel: ClientListViewModel by viewModel()
    private val client = Client("", "", "")

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentClientFormBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpButtons()
    }

    private fun setUpButtons() {
        binding.apply {
            buttonSave.setOnClickListener {
                createClient()
            }
            buttonBack.setOnClickListener {
                findNavController().navigateUp()
            }
        }
    }

    private fun createClient() {
        binding.apply {
            client.dni = dni.text.toString()
            client.name = name.text.toString()
            client.email = email.text.toString()
        }
        viewModel.saveClient(client)
        findNavController().navigateUp()
    }
}