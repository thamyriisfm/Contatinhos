package com.tfmdev.contatinhos.ui.utils

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tfmdev.contatinhos.data.remote.AdviceSlipRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DashboardViewModel
@Inject constructor(private val adviceSlipRepository: AdviceSlipRepository) : ViewModel() {

    private val _advice = MutableLiveData<String>()
    val advice: LiveData<String> = _advice

    fun getAdvice() = viewModelScope.launch {
        adviceSlipRepository.getAdvice().body()?.slip?.advice?.let { result ->
            _advice.postValue(result)
        }
    }
}