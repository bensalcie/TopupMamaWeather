package app.bensalcie.weathertask.ui.details.repo

import app.bensalcie.weathertask.data.ResultData
import app.bensalcie.weathertask.db.ForecastCityDao
import app.bensalcie.weathertask.db.ForecastCityModel
import app.bensalcie.weathertask.domain.api.ApiService
import app.bensalcie.weathertask.domain.api.BaseDataSource

class DetailsRepositoryImp(
    private val apiService: ApiService,
    private val forecastCityDao : ForecastCityDao
    ) : BaseDataSource() {

    // Retrofit Api
    suspend fun findCityForecastData(city:String) = getResult {
        apiService.findCityForecastData(city)
    }

    // Local Room

    suspend fun insertForecastCity(forecastCity: ForecastCityModel) = try {
        ResultData.Success(data = forecastCityDao.insertForecastCity(forecastCity))
    }catch (e : Exception){
        ResultData.Failure(msg = e.message.toString())
    }

    suspend fun getForecastCity(id : Long) = try {
        ResultData.Success(data = forecastCityDao.getForecastCity(id))
    }catch (e : Exception){
        ResultData.Failure(msg = e.message.toString())
    }




}