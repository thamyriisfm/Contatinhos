package com.tfmdev.contatinhos.data.remote

import retrofit2.Response
import retrofit2.http.GET

interface AdviceSlipAPI {

    @GET("/advice")
    suspend fun getAdvice(): Response<AdviceSlip>

}