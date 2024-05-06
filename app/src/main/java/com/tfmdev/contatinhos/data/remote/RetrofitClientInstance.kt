package com.tfmdev.contatinhos.data.remote

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitClientInstance {

    private var retrofit: Retrofit? = null

    private fun getRetrofitInstance(baseUrl: String): Retrofit? {
        if (retrofit == null) {
            val loggingInterceptor =
                HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BODY }
            val client = OkHttpClient.Builder().addInterceptor(loggingInterceptor).build()
            retrofit = Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build()
        }
        return retrofit
    }

    fun getAdviceSlipInstance(): Retrofit? {
        return getRetrofitInstance(ADVICE_URL)
    }

    companion object {
        const val ADVICE_URL = "https://api.adviceslip.com"
    }
}