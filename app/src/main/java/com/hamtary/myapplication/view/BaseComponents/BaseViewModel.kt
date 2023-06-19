package com.hamtary.myapplication.view.BaseComponents

import android.content.Context
import android.widget.Toast
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.hamtary.myapplication.helpers.Injection
import com.hamtary.myapplication.view.BaseComponents.userViewModel.UserViewModel
import io.reactivex.disposables.CompositeDisposable

private const val TAG = "BaseViewModel"

open class BaseViewModel(activity: FragmentActivity) : ViewModel() {

    private val mDisposable = CompositeDisposable()

    private val userViewModelFactory = Injection.provideUserVMFactory(context = activity.applicationContext)
    val mUserViewModel = ViewModelProvider(activity, userViewModelFactory)[UserViewModel::class.java]

    fun showToast(context: Context, message: String) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }

    override fun onCleared() {
        super.onCleared()
        mDisposable.dispose()
    }
}