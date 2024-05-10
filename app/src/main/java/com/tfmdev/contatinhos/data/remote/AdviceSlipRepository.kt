package com.tfmdev.contatinhos.data.remote

import javax.inject.Inject

class AdviceSlipRepository
@Inject constructor(private val adviceSlipHelper: AdviceSlipHelper) {
    suspend fun getAdvice() = adviceSlipHelper.getAdvice()
}