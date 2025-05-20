package com.dgd.pmdm_mayo.presentation

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.dgd.pmdm_mayo.databinding.FragmentClientListBinding
import com.dgd.pmdm_mayo.domain.Client
import com.dgd.pmdm_mayo.presentation.adapter.ClientListAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel

class ClientListFragment : Fragment() {

    private var _binding: FragmentClientListBinding? = null
    private val binding get() = _binding!!
    private val viewModel: ClientListViewModel by viewModel()
    private lateinit var clientListAdapter: ClientListAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentClientListBinding.inflate(inflater, container, false)
        setUpView()
        return binding.root
    }

    private fun setUpView() {
        binding.apply {
            clientList.apply {
                layoutManager = LinearLayoutManager(requireContext())
                clientListAdapter = ClientListAdapter { client ->
                    viewModel.deleteClient(client)
                }
                adapter = clientListAdapter
            }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //viewModel.insertDataTest()
        viewModel.loadClientList()
        setUpObserver()
    }

    private fun setUpObserver() {
        val observer = Observer<ClientListViewModel.UiState> { uiState ->
            if (uiState.isLoading) {
                Log.d("@dev", "Cargando...")
            } else {
                Log.d("@dev", "Cargado")
            }
            if (uiState.error != null) {
                Log.d("@dev", uiState.error)
            } else {
                bindData(uiState.clientList)
            }
        }

        viewModel.uiState.observe(viewLifecycleOwner, observer)
    }

    private fun bindData(clientList: List<Client>) {
        clientListAdapter.submitList(clientList)
    }
}