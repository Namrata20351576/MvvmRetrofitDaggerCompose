package com.nams.mvvmretrofitdaggercompose.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.nams.mvvmretrofitdaggercompose.R
import com.nams.mvvmretrofitdaggercompose.models.Product
import com.nams.mvvmretrofitdaggercompose.viewmodels.ProductViewModel
import kotlinx.coroutines.launch

@Composable
fun ProductScreen(viewModel: ProductViewModel) {

    val scope = rememberCoroutineScope()

    LaunchedEffect(Unit) {
        scope.launch {
            viewModel.getProducts()
        }
    }
    val products by viewModel.products.collectAsState()
    displayProduct(products)
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun previewProduct() {
    val productList = mutableListOf<Product>()
    productList.add(Product("category", "description", 1, "", 11.00, "Hii--1"))
    productList.add(Product("category", "description", 1, "", 11.00, "Hii--2"))
    productList.add(Product("category", "description", 1, "", 11.00, "Hii--3"))
    productList.add(Product("category", "description", 1, "", 11.00, "Hii--4"))
    productList.add(Product("category", "description", 1, "", 11.00, "Hii--5"))
    productList.add(Product("category", "description", 1, "", 11.00, "Hii--6"))
    productList.add(Product("category", "description", 1, "", 11.00, "Hii--7"))
    productList.add(Product("category", "description", 1, "", 11.00, "Hii--8"))
    productList.add(Product("category", "description", 1, "", 11.00, "Hii==9"))
    productList.add(Product("category", "description", 1, "", 11.00, "Hii--666"))
    productList.add(Product("category", "description", 1, "", 11.00, "Hii--7"))
    productList.add(Product("category", "description", 1, "", 11.00, "Hii---7"))
    displayProduct(productList)
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun previewNoProduct() {
    val productList = mutableListOf<Product>()
   displayProduct(productList)
}

@Composable
fun displayProduct(data: List<Product>) {
    if (data != null && data.isNotEmpty()) {
        val state = rememberLazyGridState()
        LazyVerticalGrid(
            state = state,
            columns = GridCells.Fixed(2),
            modifier = Modifier
                .padding(16.dp),
            content = {
                items(data) { item ->
                    ProductListItem(
                        item.image,
                        item.title,
                        item.description,
                        item.price
                    )
                }
            })
    } else {
        Column(
            modifier = Modifier
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = stringResource(id = R.string.no_product),
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}

@Composable
fun ProductListItem(
    image: String,
    title: String,
    description: String,
    price: Double
) {


    Card(modifier = Modifier.padding(8.dp), elevation = 8.dp) {
        Column() {
            AsyncImage(
                modifier = Modifier
                    .padding(start = 8.dp)
                    .aspectRatio(1f),
                model = image,
                placeholder = painterResource(id = R.drawable.ic_launcher_foreground),
                error = painterResource(id = R.drawable.ic_launcher_foreground),
                contentDescription = "The delasign logo",
            )
            Text(
                text = title,
                modifier = Modifier.padding(start = 8.dp),
                fontWeight = FontWeight.Bold,
                fontSize = 12.sp
            )
            Text(
                text = description,
                modifier = Modifier.padding(start = 8.dp),
                fontWeight = FontWeight.Normal,
                fontSize = 10.sp,
                maxLines = 3
            )
            Text(
                text = stringResource(R.string.Rs) + price.toString(),
                modifier = Modifier.padding(start = 8.dp),
                fontWeight = FontWeight.Normal,
                fontSize = 10.sp,
                maxLines = 3
            )
        }
    }

}
