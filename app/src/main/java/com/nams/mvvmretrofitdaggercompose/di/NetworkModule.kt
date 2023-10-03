package com.nams.mvvmretrofitdaggercompose.di

import com.nams.mvvmretrofitdaggercompose.retrofit.ProductAPI
import com.nams.mvvmretrofitdaggercompose.utils.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class NetworkModule {

    @Singleton
    @Provides
    fun providesRetrofit() : Retrofit{
        return Retrofit.Builder().baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Singleton
    @Provides
    fun providesProductAPI(retrofit: Retrofit) : ProductAPI{
        return retrofit.create(ProductAPI::class.java)
    }
}