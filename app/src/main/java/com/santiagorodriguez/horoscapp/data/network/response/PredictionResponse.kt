package com.santiagorodriguez.horoscapp.data.network.response

import com.google.gson.annotations.SerializedName
import com.santiagorodriguez.horoscapp.domain.model.PredictionModel

data class PredictionResponse(
    @SerializedName("date") val date: String,
    @SerializedName("horoscope") val horoscope: String,
    @SerializedName("sing") val sign: String
){
    fun toDomain():PredictionModel{
        return PredictionModel(horoscope = horoscope,
            sign = sign
        )
    }
}