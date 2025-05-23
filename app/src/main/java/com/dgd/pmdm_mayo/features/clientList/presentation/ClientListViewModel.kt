package com.dgd.pmdm_mayo.features.clientList.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dgd.pmdm_mayo.features.clientList.domain.Client
import com.dgd.pmdm_mayo.features.clientList.domain.DeleteClientUseCase
import com.dgd.pmdm_mayo.features.clientList.domain.GetClientListUseCase
import com.dgd.pmdm_mayo.features.clientList.domain.SaveClientListUseCase
import com.dgd.pmdm_mayo.features.clientList.domain.SaveClientUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.koin.android.annotation.KoinViewModel

@KoinViewModel
class ClientListViewModel(
    private val getClientListUseCase: GetClientListUseCase,
    private val saveClientListUseCase: SaveClientListUseCase,
    private val deleteClientUseCase: DeleteClientUseCase,
    private val saveClientUseCase: SaveClientUseCase
) : ViewModel() {

    private val _uiState = MutableLiveData<UiState>()
    val uiState: LiveData<UiState> = _uiState

    fun loadClientList() {
        _uiState.postValue(UiState(isLoading = true))
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val clientList = getClientListUseCase()
                _uiState.postValue(UiState(clientList = clientList))
            } catch (e: Exception) {
                _uiState.postValue(UiState(error = e.toString()))
            }
        }
    }

    fun deleteClient(client: Client) {
        viewModelScope.launch(Dispatchers.IO) {
            deleteClientUseCase(client)
        }
    }

    fun saveClient(client: Client) {
        viewModelScope.launch(Dispatchers.IO) {
            saveClientUseCase(client)
        }
    }

    fun insertDataTest() {
        val clientList = listOf(
            Client("1111111A", "Diego", "diego@gmail.com"),
            Client("2222222B", "Alberto", "alberto@gmail.com")
        )

        viewModelScope.launch(Dispatchers.IO) {
            saveClientListUseCase(clientList)
        }
    }

    data class UiState(
        val isLoading: Boolean = false,
        val error: String? = null,
        val clientList: List<Client> = emptyList()
    )
}