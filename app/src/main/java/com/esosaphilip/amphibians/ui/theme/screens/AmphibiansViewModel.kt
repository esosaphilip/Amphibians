package com.esosaphilip.amphibians.ui.theme.screens

import com.esosaphilip.amphibians.AmphibiansApplication
import com.esosaphilip.amphibians.network.Amphim
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.esosaphilip.amphibians.data.AmphibiansRepository
import com.esosaphilip.amphibians.network.AmphimItem
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException


sealed interface AmpsUiState{
    data class Success(val amps: List<AmphimItem>) : AmpsUiState
    object Error : AmpsUiState
    object Loading : AmpsUiState
}


class AmphibiansViewModel(private val amphibiansRepository: AmphibiansRepository): ViewModel() {

    var ampsUiState: AmpsUiState by mutableStateOf( AmpsUiState.Loading)

    init {
        getAmphibiansDatas()
    }

    private fun getAmphibiansDatas() {
   viewModelScope.launch{
    ampsUiState = try {
        AmpsUiState.Success(
            amphibiansRepository.getAmphibiansDatas()

        )

    }catch (_: IOException) {

        AmpsUiState.Error
    }catch (e: HttpException) {

        AmpsUiState.Error
    }


}


    }
   companion object{
       val Factory: ViewModelProvider.Factory = viewModelFactory {
           initializer {
               val application = (this[APPLICATION_KEY] as AmphibiansApplication)
               val amphibiansRepository = application.container.amphibiansRepository
               AmphibiansViewModel(amphibiansRepository = amphibiansRepository)
           }
       }
   }

}