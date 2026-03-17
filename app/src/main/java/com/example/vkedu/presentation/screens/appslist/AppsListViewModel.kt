package com.example.vkedu.presentation.screens.appslist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.vkedu.data.AppsRepository
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class AppsListViewModel(
    private val repository: AppsRepository = AppsRepository()
) : ViewModel() {

    private val _state = MutableStateFlow<AppsListState>(AppsListState.Loading)
    val state: StateFlow<AppsListState> = _state.asStateFlow()

    private val _event = Channel<AppsListEvent>()
    val event = _event.receiveAsFlow()

    init {
        loadApps()
    }

    private fun loadApps(forceError: Boolean = false) {
        viewModelScope.launch {
            _state.value = AppsListState.Loading
            repository.getApps(shouldError = forceError)
                .catch { e ->
                    _state.value = AppsListState.Error(e.message ?: "Неизвестная ошибка")
                }
                .collect { apps ->
                    _state.value = AppsListState.Success(
                        apps = apps,
                        isListView = true
                    )
                }
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

    fun retryLoading() {
        loadApps()
    }
}