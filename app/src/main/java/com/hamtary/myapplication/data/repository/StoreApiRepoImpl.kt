package com.hamtary.myapplication.data.repository

import com.hamtary.myapplication.data.model.ProductListResponseModel
import com.hamtary.myapplication.data.model.ProductResponseModel
import com.hamtary.myapplication.data.remote.StoreApiInterface
import com.hamtary.myapplication.domain.repository.StoreApIRepo
import javax.inject.Inject

class StoreApiRepoImpl @Inject constructor(private val api: StoreApiInterface) : StoreApIRepo {

    override suspend fun getProductsList(): ProductListResponseModel {
        return api.getProductsList()
    }

    override suspend fun getProductByID(id: Int): ProductResponseModel {
        return api.getProductByID(id = id)
    }

}