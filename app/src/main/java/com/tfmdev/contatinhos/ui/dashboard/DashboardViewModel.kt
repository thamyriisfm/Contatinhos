package com.tfmdev.contatinhos.ui.dashboard

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tfmdev.contatinhos.data.remote.AdviceSlipAPI
import com.tfmdev.contatinhos.data.remote.RetrofitClientInstance
import kotlinx.coroutines.launch

class DashboardViewModel : ViewModel() {

    private val _advice = MutableLiveData<String>()
    val advice: LiveData<String> = _advice

    fun getAdvice() {
        val retrofitClientInstance =
            RetrofitClientInstance().getAdviceSlipInstance()?.create(AdviceSlipAPI::class.java)
        viewModelScope.launch {
            val result = retrofitClientInstance?.getAdvice()
            _advice.postValue(result?.body()?.slip?.advice)
        }
    }
}