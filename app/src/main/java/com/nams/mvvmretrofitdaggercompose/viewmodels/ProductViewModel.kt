package com.nams.mvvmretrofitdaggercompose.viewmodels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nams.mvvmretrofitdaggercompose.models.Product
import com.nams.mvvmretrofitdaggercompose.repository.ProductRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProductViewModel @Inject constructor(private val repository: ProductRepository) :
    ViewModel() {
    private val _posts = MutableStateFlow(emptyList<Product>())
    val posts: StateFlow<List<Product>> = _posts

    suspend fun getProducts() {
        _posts.value = repository.getProducts()
    }
}