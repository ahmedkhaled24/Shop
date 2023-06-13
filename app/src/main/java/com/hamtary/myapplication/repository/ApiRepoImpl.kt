package com.hamtary.myapplication.repository

import com.hamtary.myapplication.data.network.ApiService
import com.hamtary.myapplication.models.Category
import com.hamtary.myapplication.models.Data
import com.hamtary.myapplication.models.MyResponse
import com.hamtary.myapplication.utils.Resource
import com.hamtary.myapplication.utils.Utils.tryCatch
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class ApiRepoImpl @Inject constructor(private val apiService: ApiService) : ApiRepo {

    override suspend fun getAllCategories(): Resource<MyResponse<Data<Category>>> =
        withContext(Dispatchers.IO) {
            tryCatch {
                val result = apiService.getAllCategories()
                Resource.Success(result)
            }
        }
}
