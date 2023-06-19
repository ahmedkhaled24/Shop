package com.hamtary.myapplication.view.viewModels

import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.LifecycleOwner
import com.hamtary.myapplication.view.BaseComponents.BaseViewModel
import com.hamtary.myapplication.view.Navigators.SignInNavigator

private const val TAG = "TagLoginVM"

class SignInViewModel(
    private val activity: FragmentActivity,
    private var viewLifecycleOwner: LifecycleOwner,
    private var navigator: SignInNavigator
) : BaseViewModel(activity) {

//    private fun getTokenAPI(email: String, password: String) {
//        Log.d(TAG, "getTokenAPI: $email")
//        Log.d(TAG, "getTokenAPI: $password")
//        navigator.showProgressBar()
//        mUserViewModel.getTokenViewM(email, password).observe(viewLifecycleOwner) {
//            // handle success
//            it.data?.getContentIfNotHandled()?.let { response ->
//                Log.d(TAG, "getTokenAPI: $response")
//                if (response.status)
//                    navigator.onGetTokenSuccess(response)
//                else
//                    showToast(activity, response.errMsg)
//                navigator.hideProgressBar()
//            }
//            // handle error
//            it.error?.getContentIfNotHandled()?.let { error ->
//                Log.d(TAG, "getTokenAPI error: $error")
//                showToast(activity, error)
//                navigator.hideProgressBar()
//            }
//        }
//    }
}