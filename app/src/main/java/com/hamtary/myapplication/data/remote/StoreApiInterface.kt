package com.hamtary.myapplication.data.remote

import com.hamtary.myapplication.data.model.ProductListResponseModel
import com.hamtary.myapplication.data.model.ProductResponseModel
import retrofit2.http.GET
import retrofit2.http.Path

interface StoreApiInterface {

    @GET("products")
    suspend fun getProductsList(): ProductListResponseModel

    @GET("products/{product_id}")
    suspend fun getProductByID(@Path("product_id") id:Int): ProductResponseModel
}