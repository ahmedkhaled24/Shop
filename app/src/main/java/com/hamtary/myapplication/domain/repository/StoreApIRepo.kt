package com.hamtary.myapplication.domain.repository

import com.hamtary.myapplication.data.model.ProductListResponseModel
import com.hamtary.myapplication.data.model.ProductResponseModel

interface StoreApIRepo {
    suspend fun getProductsList(): ProductListResponseModel
    suspend fun getProductByID(id:Int): ProductResponseModel
}