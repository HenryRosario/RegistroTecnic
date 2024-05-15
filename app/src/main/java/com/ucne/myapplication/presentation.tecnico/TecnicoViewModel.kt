package com.ucne.myapplication.presentation.tecnico
import androidx.lifecycle.AbstractSavedStateViewModelFactory
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ucne.myapplication.data.local.entities.TecnicoEntity
import com.ucne.myapplication.data.repository.TecnicoRepository
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class TecnicoViewModel(private val repository: TecnicoRepository) : ViewModel() {

    val tecnicos = repository.getTecnico()
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5_000),
            initialValue = emptyList()
        )

    fun saveTecnico(tecnicos: TecnicoEntity) {
        viewModelScope.launch {
            repository.saveTecnico(tecnicos)
        }
    }


    companion object {
        fun provideFactory(
            repository: TecnicoRepository
        ): AbstractSavedStateViewModelFactory =
            object : AbstractSavedStateViewModelFactory() {
                @Suppress("UNCHECKED_CAST")
                override fun <T : ViewModel> create(
                    key: String,
                    modelClass: Class<T>,
                    handle: SavedStateHandle
                ): T {
                    return TecnicoViewModel(repository) as T
                }
            }
    }
}