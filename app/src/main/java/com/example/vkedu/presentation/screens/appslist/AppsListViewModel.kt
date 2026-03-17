package com.example.vkedu.presentation.screens.appslist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.vkedu.data.appsList
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class AppsListViewModel : ViewModel() {

    private val _state = MutableStateFlow<AppsListState>(AppsListState.Loading)
    val state: StateFlow<AppsListState> = _state.asStateFlow()

    private val _event = Channel<AppsListEvent>()
    val event = _event.receiveAsFlow()

    init {
        loadApps()
    }

    private fun loadApps() {
        viewModelScope.launch {
            // Имитация загрузки из сети/БД
            _state.value = AppsListState.Success(apps = appsList)
        }
    }

    fun toggleView() {
        _state.update { currentState ->
            if (currentState is AppsListState.Success) {
                currentState.copy(isListView = !currentState.isListView)
            } else {
                currentState
            }
        }
    }

    fun onLogoClick() {
        viewModelScope.launch {
            _event.send(AppsListEvent.ShowSnackbar("Вы нажали на логотип RuStore"))
        }
    }
}