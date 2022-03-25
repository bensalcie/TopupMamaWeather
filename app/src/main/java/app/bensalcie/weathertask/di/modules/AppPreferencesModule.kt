package app.bensalcie.weathertask.di.modules

import android.content.Context
import android.content.SharedPreferences
import app.bensalcie.weathertask.BaseApp
import app.bensalcie.weathertask.R
import app.bensalcie.weathertask.core.utils.AppPreferences

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppPreferencesModule {

    @Singleton
    @Provides
    fun providesApplication(@ApplicationContext app:Context): BaseApp {
        return app as BaseApp
    }

    @Singleton
    @Provides
    fun providesSharedPreferences(@ApplicationContext context:Context): SharedPreferences {
        return context.getSharedPreferences(
            context.getString(R.string.app_name) + "1",
            Context.MODE_PRIVATE
        )
    }

    @Singleton
    @Provides
    fun providesSharedPreferencesEditor(mSharedPreferences:SharedPreferences) : SharedPreferences.Editor {
         return mSharedPreferences.edit()
     }

    @Singleton
    @Provides
    fun providesSharedPreferencesHelper(sharedPreferences: SharedPreferences,sharedPreferencesEditor:SharedPreferences.Editor): AppPreferences {
        return AppPreferences(sharedPreferences,sharedPreferencesEditor)
    }

}