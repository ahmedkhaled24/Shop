package com.hamtary.myapplication.view.BaseComponents.userViewModel

import android.content.Context
import com.hamtary.myapplication.helpers.BaseObservable
import com.hamtary.myapplication.network.ApiService
import io.reactivex.disposables.CompositeDisposable
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.RequestBody
import okhttp3.RequestBody.Companion.toRequestBody

private const val TAG = "appDebug"

class UserViewModel(val context: Context, private val mApiService: ApiService) : BaseObservable() {
    private val mDisposable = CompositeDisposable()

    /************ LiveData ***********/
//    private val _recommendedMealsLiveData = MutableLiveData<Resource<RecommendedMealsResponse>>()

    /************ Handle APIs ***********/

//    fun getRestaurantsByCategoryViewM(category: Int): MutableLiveData<Resource<RestaurantsByCategoryResponse>> {
//        Log.d(TAG, "getRestaurantsByCategoryViewM category : $category")
//        _getRestaurantsByCategoryLiveData.value = Resource.loading(true)
//        mApiService.getRestaurantsByCategory(category)
//            .subscribeOn(Schedulers.io())
//            .observeOn(AndroidSchedulers.mainThread())
//            .subscribe(object : SingleObserver<RestaurantsByCategoryResponse> {
//                override fun onSubscribe(d: Disposable) {
//                    mDisposable.add(d)
//                }
//
//                override fun onSuccess(t: RestaurantsByCategoryResponse) {
//                    Log.d(TAG, "getRestaurantsByCategoryViewM onSuccess")
//                    _getRestaurantsByCategoryLiveData.value = Resource.data(t)
//                }
//
//                override fun onError(e: Throwable) {
//                    Log.d(TAG, "UserViewModel, getRestaurantsByCategoryViewM onError 1: ${e.message.toString()}")
//                    var errorMessage = context.getString(R.string.Something_went_wrong_please_try_again)
//                    when (e) {
//                        is UnknownHostException, is SocketTimeoutException, is IOException -> {
//                            Log.d(TAG, "UserViewModel, getRestaurantsByCategoryViewM onError 2: UnKnownHostException: ${e.message}")
//                            errorMessage = context.getString(R.string.Please_Check_Your_Internet_Connection)
//                        }
//
//                        is HttpException -> {
//                            Log.d(TAG, "getRestaurantsByCategoryViewM onError 3 code error: ${e.code()}")
////                            val errorBody = e.response()!!.errorBody()
//                        }
//
//                        else -> {
//                            Log.d(TAG, "UserViewModel, else: getRestaurantsByCategoryViewM onError 6 : Unknown Error: $e")
//                        }
//                    }
//                    _getRestaurantsByCategoryLiveData.value = Resource.error(errorMessage)
//                }
//            })
//        return _getRestaurantsByCategoryLiveData
//    }





    /************ Others ***********/
//    //Expired token
//    fun sessionExpired(activity: FragmentActivity): String {
//        // Delete Shared Preference
//        SP.deleteAllSharedPrefs(context)
//        // activity.startActivity(Intent(activity,LOGIN_ACTIVITY::class.java))
//         activity.finish()
//
//        return ""
//    }

//    private fun getToken(): Map<String, String> {
//        val headers = HashMap<String, String>()
//        val authValue = "Bearer $token"
//        headers["Authorization"] = authValue
//        headers["Accept"] = "application/json"
//        return headers
//    }

    private fun toRequestBody(item: String): RequestBody {
        return item.trim().replace("\"", "").toRequestBody("multipart/form-data".toMediaTypeOrNull())
    }

    override fun onCleared() {
        super.onCleared()
        mDisposable.dispose()
    }

}
