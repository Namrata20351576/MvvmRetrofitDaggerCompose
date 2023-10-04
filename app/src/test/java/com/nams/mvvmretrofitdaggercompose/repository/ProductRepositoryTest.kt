package com.nams.mvvmretrofitdaggercompose.repository

import com.nams.mvvmretrofitdaggercompose.retrofit.ProductAPI
import kotlinx.coroutines.test.runTest
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations
import retrofit2.Response

class ProductRepositoryTest {

    @Mock
    lateinit var productApi: ProductAPI
    @Before
    fun setUp() {
        MockitoAnnotations.openMocks(this)
    }

    @org.junit.Test
    fun testGetNoProducts()= runTest {
        Mockito.`when`(productApi.getProducts()).thenReturn(Response.success(emptyList()))
        val ut = ProductRepository(productApi)
        val result = ut.getProducts()
        Assert.assertEquals(0,  result.size)
    }

    @org.junit.Test
    fun testGetWithProducts()= runTest {
        Mockito.`when`(productApi.getProducts()).thenReturn(Response.success(emptyList()))
        val ut = ProductRepository(productApi)
        val result = ut.getProducts()
        Assert.assertEquals(0,  result.size)
    }

    @After
    fun tearDown() {
    }
}