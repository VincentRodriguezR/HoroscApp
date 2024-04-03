package com.santiagorodriguez.horoscapp.data

import android.util.Log
import com.santiagorodriguez.horoscapp.data.network.HoroscopeApiService
import com.santiagorodriguez.horoscapp.data.network.response.PredictionResponse
import com.santiagorodriguez.horoscapp.domain.Repository
import com.santiagorodriguez.horoscapp.domain.model.PredictionModel
import javax.inject.Inject

class RepositoryImp @Inject constructor(private val apiService: HoroscopeApiService) : Repository {
    override suspend fun getPrediction(sign: String): PredictionModel? {
        runCatching { apiService.getHoroscope(sign) }
            .onSuccess { return it.toDomain() }
            .onFailure { Log.i("Error", "Ha ocurrido un error ${it.message}") }

        return null
    }
}