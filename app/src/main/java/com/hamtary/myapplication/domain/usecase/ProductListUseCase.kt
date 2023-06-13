package com.hamtary.myapplication.domain.usecase

import com.hamtary.myapplication.domain.repository.StoreApIRepo
import com.hamtary.myapplication.utils.Resource
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class ProductListUseCase @Inject constructor(private val repository: StoreApIRepo) {
    operator fun invoke() = flow {
        try {
            emit(Resource.Loading())
            val productResponseModel = repository.getProductsList()
            if (!productResponseModel.isEmpty()) {
                emit(Resource.Success(data = productResponseModel))
            } else {
                emit(Resource.Error("Data Return With Null"))
            }
        } catch (e: HttpException) {
            emit(Resource.Error(e.localizedMessage ?: "An unexpected error occurred"))
        } catch (e: IOException) {
            emit(Resource.Error("Couldn't reach server. Please check your internet connection"))
        }
    }
}