package com.hamtary.myapplication.db

import android.content.Context
import android.content.SharedPreferences

class SP {

    companion object {
        private lateinit var sharedPreferences: SharedPreferences

        /************ Set-Data ***************************/
        fun setCheckOnLanguage(context: Context, lang: String) {
            sharedPreferences = context.getSharedPreferences("LANGUAGE", Context.MODE_PRIVATE)
            val editor = sharedPreferences.edit().putString("LANGUAGE", lang)
            editor.apply()
        }

        /************************************************/
        /***************** Get-Data *********************/
        /************************************************/
        fun getCheckOnLanguage(context: Context): String {
            sharedPreferences = context.getSharedPreferences("LANGUAGE", Context.MODE_PRIVATE)
            return sharedPreferences.getString("LANGUAGE", "ENGLISH")!!
        }

        /************ Delete-All-Data ********************/
        fun deleteAllSharedPrefs(context: Context) {
            context.getSharedPreferences("USER", Context.MODE_PRIVATE).edit().clear().apply()
        }

        fun deleteCheckoutAddress(context: Context) {
            context.getSharedPreferences("CHECKOUT_ADDRESS", Context.MODE_PRIVATE).edit().clear().apply()
        }
    }
}