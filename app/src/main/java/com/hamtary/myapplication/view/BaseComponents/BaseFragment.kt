package com.hamtary.myapplication.view.BaseComponents

import android.widget.Toast
import androidx.fragment.app.Fragment
import java.text.DecimalFormat
import java.text.NumberFormat
import java.util.*

private const val TAG = "BaseFragment"

open class BaseFragment: Fragment() {

    private val nf = NumberFormat.getCurrencyInstance(Locale.ENGLISH)
    val dec = nf as DecimalFormat

    fun numTwoDigits(num: Double): String{
//        return String.format(Locale.ENGLISH, "%.1f", num)

        dec.applyPattern("######.##")
        return replaceComma(dec.format(num).toFloat().toString())
    }


    private fun replaceComma(num: String) : String{
        return num.replace(",","")
    }

    fun showToast(message: String){
        Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
    }
}