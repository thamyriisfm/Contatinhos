package com.tfmdev.contatinhos.data.remote

import retrofit2.Response

interface AdviceSlipHelper {
    suspend fun getAdvice(): Response<AdviceSlip>
}