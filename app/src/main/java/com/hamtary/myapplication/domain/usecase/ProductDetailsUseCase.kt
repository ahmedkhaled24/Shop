package com.hamtary.myapplication.domain.usecase

import com.hamtary.myapplication.domain.repository.StoreApIRepo
import com.hamtary.myapplication.utils.Resource
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class ProductDetailsUseCase @Inject constructor(private val repository: StoreApIRepo) {

    operator fun invoke(id: Int) = flow {
        try {
            emit(Resource.Loading())
            val productResponseModel = repository.getProductByID(id = id)
            emit(Resource.Success(data = productResponseModel))
        } catch (e: HttpException) {
            emit(Resource.Error(e.localizedMessage ?: "An unexpected error occurred"))
        } catch (e: IOException) {
            emit(Resource.Error("Couldn't reach server. Please check your internet connection"))
        }
    }
}