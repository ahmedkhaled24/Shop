package com.hamtary.myapplication.repository

import com.hamtary.myapplication.models.Category
import com.hamtary.myapplication.models.Data
import com.hamtary.myapplication.models.MyResponse
import com.hamtary.myapplication.utils.Resource

interface ApiRepo {
    suspend fun getAllCategories(): Resource<MyResponse<Data<Category>>>
}