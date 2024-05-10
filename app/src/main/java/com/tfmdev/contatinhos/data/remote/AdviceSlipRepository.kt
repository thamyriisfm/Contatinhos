package com.tfmdev.contatinhos.data.remote

import javax.inject.Inject

class AdviceSlipRepository
@Inject constructor(private val adviceSlipAPI: AdviceSlipAPI) {
    suspend fun getAdvice () = adviceSlipAPI.getAdvice()
}