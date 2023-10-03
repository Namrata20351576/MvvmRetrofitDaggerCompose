package com.nams.mvvmretrofitdaggercompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.ViewModelProvider
import com.nams.mvvmretrofitdaggercompose.ui.ProductScreen
import com.nams.mvvmretrofitdaggercompose.viewmodels.ProductViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    lateinit var mainViewModel: ProductViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            this.mainViewModel = ViewModelProvider(this).get(ProductViewModel::class.java)
            ProductScreen(viewModel = mainViewModel)
        }
    }
}