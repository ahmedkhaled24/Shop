package com.hamtary.myapplication.helpers

import android.content.Context
import com.hamtary.myapplication.network.data.RetrofitFactory
import com.hamtary.myapplication.view.BaseComponents.userViewModel.UserViewModelFactory


object Injection {
    // inject all dependencies will consumed by viewModel
    // return ViewModelFactory instance
    fun provideUserVMFactory(context: Context): UserViewModelFactory {
        val retrofit = RetrofitFactory.provideUserApiService()
        return UserViewModelFactory(
            context = context,
            userApiService = retrofit
        )
    }
}