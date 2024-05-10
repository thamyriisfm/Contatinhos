package com.tfmdev.contatinhos.data.remote

import retrofit2.Response
import javax.inject.Inject

class AdviceSlipService
@Inject constructor(private val adviceSlipAPI: AdviceSlipAPI) :
    AdviceSlipAPI {
    override suspend fun getAdvice(): Response<AdviceSlip> =
        adviceSlipAPI.getAdvice()

}