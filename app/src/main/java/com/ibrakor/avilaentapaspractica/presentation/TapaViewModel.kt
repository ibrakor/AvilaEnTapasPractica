package com.ibrakor.avilaentapaspractica.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ibrakor.avilaentapaspractica.app.ErrorApp
import com.ibrakor.avilaentapaspractica.domain.GetTapaUseCase
import com.ibrakor.avilaentapaspractica.domain.Tapa
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class TapaViewModel (private val getTapaUseCase: GetTapaUseCase):ViewModel(){

    private val _uiState=MutableLiveData<UiState>()
    val uiState:LiveData<UiState> = _uiState

    fun loadTapa(){
        _uiState.value= UiState(isLoading = true)
        viewModelScope.launch(Dispatchers.IO){
            delay(2000)
            getTapaUseCase().fold(
                {responseError(it)},
                {responseGetTapaSuccess(it)}
            )
        }
    }

    private fun responseGetTapaSuccess(tapa: List<Tapa>) {
        _uiState.postValue(UiState(tapas=tapa, isLoading = false))
    }

    private fun responseError(errorApp: ErrorApp) {
        _uiState.postValue(UiState(errorApp =errorApp, isLoading = false))
    }


    data class UiState(val errorApp :ErrorApp?=null,
                       val isLoading: Boolean=false,
                       val tapas:List<Tapa>?=null
    )

}