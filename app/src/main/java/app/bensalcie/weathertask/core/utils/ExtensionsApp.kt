package app.bensalcie.weathertask.core.utils

import app.bensalcie.weathertask.core.utils.AppConstants.IS_FIRST
import app.bensalcie.weathertask.core.utils.AppConstants.LOCALE
import java.util.*


object ExtensionsApp {

    fun getLocale(appPreferences: AppPreferences): String =appPreferences.getStringValue(LOCALE, Locale.getDefault().language)
    fun isFirst(appPreferences: AppPreferences): Boolean =appPreferences.getBooleanValue(IS_FIRST , false)


}
