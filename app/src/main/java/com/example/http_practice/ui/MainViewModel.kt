package com.example.http_practice.ui

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.http_practice.data.repository.QuotesRepository
import com.example.http_practice.utils.Results
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val repository: QuotesRepository) : ViewModel() {
    val uiState = mutableStateOf(UiState())
    init {
        getQuotes()
    }



    fun getQuotes(){
        viewModelScope.launch {
            repository.getQuotes().collect{ result ->
                when(result){
                   is Results.Loading -> {
                        uiState.value = uiState.value.copy(isLoading = true, error = null)
                    }
                    is Results.Success -> {
                        uiState.value = uiState.value.copy(isLoading = false, data = result.data, error = null)
                    }
                    is Results.Error -> {
                        uiState.value = uiState.value.copy(isLoading = false, error = result.message, data = result.data)
                    }
                }

            }
        }
    }
}