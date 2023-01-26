package com.luismakeapp.navigationwithmvvm.ui

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.luismakeapp.navigationwithmvvm.data.UiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class AppViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(UiState())
    val uiState: StateFlow<UiState> = _uiState.asStateFlow()

    //Put values name and age in uiState (coroutines)
    fun nameAge(name: String, age: String){
        _uiState.update {currentState ->
            currentState.copy(name, age)
        }
    }

    fun makeCalc(){
        _uiState.update {currentStage ->
            currentStage.copy(result = 4)

        }
    }

    //When navigation come to first screen
    fun reset(){
        _uiState.update {currentStage ->
            currentStage.copy(name = "", age = "", result = 0)
        }
    }


}