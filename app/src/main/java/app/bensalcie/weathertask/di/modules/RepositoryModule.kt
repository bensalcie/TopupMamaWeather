package app.bensalcie.weathertask.di.modules

import android.app.Application
import app.bensalcie.weathertask.domain.api.ApiGooglePlaces
import app.bensalcie.weathertask.ui.home.repo.HomeRepository
import app.bensalcie.weathertask.domain.api.ApiService
import app.bensalcie.weathertask.db.CityDao
import app.bensalcie.weathertask.db.ForecastCityDao
import app.bensalcie.weathertask.ui.details.repo.DetailsRepository
import app.bensalcie.weathertask.ui.details.repo.DetailsRepositoryImp
import app.bensalcie.weathertask.ui.home.data.LocationProvider
import app.bensalcie.weathertask.ui.home.repo.HomeRepositoryImp
import app.bensalcie.weathertask.widget.WidgetRepository
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
object RepositoryModule {


    @Provides
    fun provideLocationProviderClient(application: Application): FusedLocationProviderClient {
        return LocationServices.getFusedLocationProviderClient(application.applicationContext)
    }

    @Provides
    fun provideLocationProvider(context: Application, client: FusedLocationProviderClient
    ): LocationProvider {
        return LocationProvider(context.applicationContext, client)
    }

    @Provides
    fun providesHomeRepository(homeRepositoryImp: HomeRepositoryImp, locationProvider: LocationProvider): HomeRepository {
        return HomeRepository(homeRepositoryImp , locationProvider)
    }

    @Provides
    fun providesHomeRepositoryImp(apiService: ApiService, apiGooglePlaces : ApiGooglePlaces  , cityDao : CityDao): HomeRepositoryImp {
        return HomeRepositoryImp(apiService  , apiGooglePlaces  , cityDao)
    }

    @Provides
    fun providesDetailsRepository(detailsRepositoryImp: DetailsRepositoryImp): DetailsRepository {
        return DetailsRepository(detailsRepositoryImp )
    }

    @Provides
    fun providesDetailsRepositoryImp(apiService: ApiService , forecastCityDao : ForecastCityDao): DetailsRepositoryImp {
        return DetailsRepositoryImp(apiService , forecastCityDao)
    }

    @Provides
    fun providesWidgetRepository(cityDao : CityDao): WidgetRepository {
        return WidgetRepository(cityDao)
    }





}