package com.hamtary.myapplication.data.network

import com.hamtary.myapplication.models.Category
import com.hamtary.myapplication.models.Data
import com.hamtary.myapplication.models.MyResponse
import retrofit2.http.GET

interface ApiService {
    @GET("categories")
    suspend fun getAllCategories(): MyResponse<Data<Category>>
}