package com.hamtary.myapplication.helpers

import android.content.Context
import android.content.res.Configuration
import android.content.res.Resources
import android.os.Build
import android.os.LocaleList
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import java.util.*

private const val TAG = "LocalizationUtil"
object LocalizationUtil {

    fun applyLanguageContext(context: Context, locale: Locale?, activity: AppCompatActivity? = null): Context {
        if (locale == null) return context
        if (locale == getLocale(context.resources.configuration)) return context

        return try {
            setupLocale(locale)
            val resources = context.resources
            val configuration = getOverridingConfig(locale, resources)
            Log.d(TAG, "applyLanguageContext: ${locale.language}")
            if (activity!=null){
                setLayoutDirection(activity)
            }
            updateResources(context, resources, configuration)
            context.createConfigurationContext(configuration)
        } catch (exception: Exception) {
            context
        }
    }

    private fun updateResources(context: Context, resources: Resources, config: Configuration) {
        resources.updateConfiguration(config, resources.displayMetrics)
        if (context.applicationContext !== context) {
            resources.updateConfiguration(config, resources.displayMetrics)
        }
    }

    private fun setupLocale(locale: Locale) {
        Locale.setDefault(locale)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            LocaleList.setDefault(LocaleList(locale))
        }
    }

    private fun getOverridingConfig(locale: Locale, resources: Resources): Configuration {
        val configuration = resources.configuration
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            configuration.setLocales(LocaleList(locale))
        } else {
            configuration.locale = locale
        }
        return configuration
    }

    private fun getLocale(configuration: Configuration): Locale {
        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            configuration.locales.get(0)
        } else {
            configuration.locale
        }
    }

    private fun setLayoutDirection(activity: AppCompatActivity){
//        if (SP.getCheckOnLanguage(activity)== C.ARABIC) {
//            activity.window.decorView.layoutDirection = View.LAYOUT_DIRECTION_RTL
//        } else {
//            activity.window.decorView.layoutDirection = View.LAYOUT_DIRECTION_LTR
//        }
    }
}
