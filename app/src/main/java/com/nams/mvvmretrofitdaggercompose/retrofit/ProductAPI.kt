package com.nams.mvvmretrofitdaggercompose.retrofit

import com.nams.mvvmretrofitdaggercompose.models.Product
import retrofit2.Response
import retrofit2.http.GET

interface ProductAPI {

    @GET("products")
    suspend fun getProducts() : Response<List<Product>>
}