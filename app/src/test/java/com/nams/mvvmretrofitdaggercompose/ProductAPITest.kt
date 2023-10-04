package com.nams.mvvmretrofitdaggercompose

import com.nams.mvvmretrofitdaggercompose.retrofit.ProductAPI
import com.nams.mvvmretrofitdaggercompose.utils.Constants
import kotlinx.coroutines.test.runTest
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ProductAPITest {

    lateinit var mockWebServer:MockWebServer
    lateinit var productAPI: ProductAPI

    @Before
    fun setup() {

        mockWebServer = MockWebServer()
        productAPI = Retrofit.Builder()
            .baseUrl(mockWebServer.url("/"))
            .addConverterFactory(GsonConverterFactory.create())
            .build().create(ProductAPI::class.java)
    }

    @Test
    fun testEmptyProduct() = runTest()
    {
        val mockResponse = MockResponse()
            mockResponse.setBody("[]")
            mockWebServer.enqueue(mockResponse)
            val response = productAPI.getProducts()
            mockWebServer.takeRequest()
            Assert.assertEquals(true, response.body()!!.isEmpty())
    }

    @Test
    fun testWithProduct() = runTest()
    {
        val mockResponse = MockResponse()
        val content = Helper.readFileResource("/response.json")
        mockResponse.setResponseCode(200)
        mockResponse.setBody(content)
        mockWebServer.enqueue(mockResponse)
        val response = productAPI.getProducts()
        mockWebServer.takeRequest()
        Assert.assertEquals(true, response.body()!!.isNotEmpty())
        Assert.assertEquals(3, response.body()!!.size)
    }

    @After
    fun tearDown() {
        mockWebServer.shutdown()
    }
}