package com.hamtary.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.hamtary.myapplication.ui.HomeFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction().replace(R.id.fragment, HomeFragment()).commit()
    }
}