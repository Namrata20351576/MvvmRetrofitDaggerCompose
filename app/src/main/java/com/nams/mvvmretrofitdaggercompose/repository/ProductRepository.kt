package com.nams.mvvmretrofitdaggercompose.repository

import android.annotation.SuppressLint
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.nams.mvvmretrofitdaggercompose.models.Product
import com.nams.mvvmretrofitdaggercompose.retrofit.ProductAPI
import javax.inject.Inject

class ProductRepository @Inject constructor(private val productAPI: ProductAPI) {

    private val _products = MutableLiveData<List<Product>>()
    val products: LiveData<List<Product>>
    get() = _products

    @SuppressLint("SuspiciousIndentation")
    suspend fun getProducts(): List<Product>
    {
        val result = productAPI.getProducts()
            return result.body()!!
    }
}