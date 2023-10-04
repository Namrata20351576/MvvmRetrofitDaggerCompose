package com.nams.mvvmretrofitdaggercompose.viewmodels

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.nams.mvvmretrofitdaggercompose.models.Product
import com.nams.mvvmretrofitdaggercompose.repository.ProductRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations
class ProductViewModelTest {

    private val testDispatcher = StandardTestDispatcher()

    @Mock
    private lateinit var repository: ProductRepository

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    @Before
    fun setUp() {
        MockitoAnnotations.openMocks(this)
        Dispatchers.setMain(testDispatcher)
    }

    @Test
    fun testGetNoProducts()= runTest {
        Mockito.`when`(repository.getProducts()).thenReturn(emptyList())
        val ut = ProductViewModel(repository)
        ut.getProducts()
        testDispatcher.scheduler.advanceUntilIdle()
        val result = ut.products.value
        Assert.assertEquals(0,  result.size)
    }

    @Test
    fun testGetWithProducts()= runTest {
        val productList = mutableListOf<Product>()
        productList.add(Product("category", "description", 1, "", 11.00, "Hii--1"))
        productList.add(Product("category", "description", 2, "", 11.00, "Hii--2"))
        productList.add(Product("category", "description", 3, "", 11.00, "Hii--3"))
        Mockito.`when`(repository.getProducts()).thenReturn(productList)
        val ut = ProductViewModel(repository)
        ut.getProducts()
        testDispatcher.scheduler.advanceUntilIdle()
        val result = ut.products.value
        Assert.assertEquals(3,  result.size)
        Assert.assertEquals(1,  result[0].id)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }
}