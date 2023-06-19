package com.hamtary.myapplication.view.BaseComponents.userViewModel

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.hamtary.myapplication.network.ApiService

class UserViewModelFactory(
    private val context: Context,
    private val userApiService: ApiService
) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(UserViewModel::class.java)) {
            return UserViewModel(context, userApiService) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }

}