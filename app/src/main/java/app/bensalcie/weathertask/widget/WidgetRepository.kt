package app.bensalcie.weathertask.widget

import app.bensalcie.weathertask.data.ResultData
import app.bensalcie.weathertask.db.CityDao
import javax.inject.Inject


class WidgetRepository @Inject constructor (private val  cityDao : CityDao) {

    suspend fun getCities() = try {
        ResultData.Success(data = cityDao.getAllCities())
    }catch (e : Exception){
        ResultData.Failure(msg = e.message.toString())
    }

}