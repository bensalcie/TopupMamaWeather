package app.bensalcie.weathertask.ui.details.repo

import app.bensalcie.weathertask.data.ResultData
import app.bensalcie.weathertask.db.ForecastCityModel
import app.bensalcie.weathertask.domain.model.forecest.ForecastCityResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow


class DetailsRepository(
    private val detailsRepositoryImp: DetailsRepositoryImp
) {

    // Retrofit Api
    fun findCityForecastData(city: String): Flow<ResultData<ForecastCityResponse>> = flow {
        emit(detailsRepositoryImp.findCityForecastData(city))
    }

    // Local

    suspend fun insertForecastCity(forecastCity: ForecastCityModel) = detailsRepositoryImp.insertForecastCity(forecastCity)

    suspend fun getForecastCity(id : Long) = detailsRepositoryImp.getForecastCity(id)


}