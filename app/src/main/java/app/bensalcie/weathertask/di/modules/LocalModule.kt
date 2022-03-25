package app.bensalcie.weathertask.di.modules

import android.content.Context
import androidx.room.Room
import app.bensalcie.weathertask.db.CityDao
import app.bensalcie.weathertask.db.CityDatabase
import app.bensalcie.weathertask.db.ForecastCityDao

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object LocalModule{

    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext context: Context): CityDatabase {
        return Room.databaseBuilder(context, CityDatabase::class.java, "cities.database")
            .fallbackToDestructiveMigration()
            .allowMainThreadQueries()
            .build()
    }

    @Singleton
    @Provides
    fun cityDao(database: CityDatabase): CityDao {
        return database.cityDao()
    }

    @Singleton
    @Provides
    fun forecastCityDao(database: CityDatabase): ForecastCityDao {
        return database.forecastCityDao()
    }

}
