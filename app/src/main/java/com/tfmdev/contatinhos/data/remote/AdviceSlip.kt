package com.tfmdev.contatinhos.data.remote

import com.google.gson.annotations.SerializedName

data class AdviceSlip(
    @SerializedName("slip")
    val slip: Slip
)

data class Slip(
    @SerializedName("slip_id")
    val id: Int,
    @SerializedName("advice")
    val advice: String
)
