package com.hamtary.myapplication.view.BaseComponents

import android.content.Context
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.hamtary.myapplication.db.SP
import com.hamtary.myapplication.helpers.LocalizationUtil
import java.util.*

private const val TAG = "BaseActivity"
open class BaseActivity: AppCompatActivity() {

    fun showToast(message: String){
        Toast.makeText(this.applicationContext, message, Toast.LENGTH_SHORT).show()
    }

//    fun openFragment(fragment: Int, homeFragment: HomeFragment) {
//        supportFragmentManager.beginTransaction().replace(fragment, homeFragment).commit()
//    }

    override fun getBaseContext(): Context {
        return LocalizationUtil.applyLanguageContext(super.getBaseContext(), Locale(SP.getCheckOnLanguage(this)))
    }

    override fun getApplicationContext(): Context {
        return LocalizationUtil.applyLanguageContext(super.getApplicationContext(), Locale(SP.getCheckOnLanguage(this)))
    }
}