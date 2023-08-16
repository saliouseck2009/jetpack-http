package com.example.http_practice.ui

import com.example.http_practice.domain.model.Quote

data class UiState (
    val isLoading: Boolean = false,
    val data: List<Quote>? = emptyList(),
    val error: String? = null
)