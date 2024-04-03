package com.santiagorodriguez.horoscapp.domain

import com.santiagorodriguez.horoscapp.data.network.response.PredictionResponse
import com.santiagorodriguez.horoscapp.domain.model.PredictionModel

interface Repository {
    suspend fun getPrediction(sign:String): PredictionModel?
}