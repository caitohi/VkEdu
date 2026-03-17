package com.example.vkedu.presentation.screens.appslist

import com.example.vkedu.data.App

sealed class AppsListState {
    data object Loading : AppsListState()
    data class Success(
        val apps: List<App>,
        val isListView: Boolean = true
    ) : AppsListState()
    data class Error(val message: String) : AppsListState()
}

sealed class AppsListEvent {
    data class ShowSnackbar(val message: String) : AppsListEvent()
}