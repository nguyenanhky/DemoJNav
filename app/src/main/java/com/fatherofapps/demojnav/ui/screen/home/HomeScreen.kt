package com.fatherofapps.demojnav.ui.screen.home

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material3.Button
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.fatherofapps.jnav.annotations.JNav

@OptIn(ExperimentalMaterial3Api::class)
@Composable
@JNav(
    name = "HomeNavigation",
    baseRoute = "home_route",
    destination = "home_destination"
)
fun HomeScreen(
    openCartScreen: (productId: Int, productName: String, productPrice: Float) -> Unit,
    openAddressBook: () -> Unit
) {

    val rememberOpenCartScreen = remember {
        { productId: Int, productName: String, productPrice: Float ->
            openCartScreen(productId, productName, productPrice)
        }
    }

    val rememberOpenAddressBook = remember {
        openAddressBook
    }

    var productId by remember {
        mutableStateOf("")
    }

    var productName by remember {
        mutableStateOf("")
    }

    var productPrice by remember {
        mutableStateOf("")
    }

    Scaffold(topBar = {
        CenterAlignedTopAppBar(title = {
            Text(text = "Home")
        }, actions = {
            IconButton(onClick = { rememberOpenAddressBook() }) {
                Icon(Icons.Default.AccountBox, contentDescription = "account")
            }
        },
            modifier = Modifier.shadow(elevation = 6.dp)
        )
    }) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp, vertical = padding.calculateTopPadding())
        ) {
            Spacer(modifier = Modifier.height(24.dp))
            TextField(value = productName, onValueChange = {
                productName = it
            }, label = { Text(text = "Product name") }, modifier = Modifier.fillMaxWidth())
            Spacer(modifier = Modifier.height(12.dp))

            TextField(value = productId,
                onValueChange = {
                    productId = it
                },
                label = { Text(text = "Product id") },
                modifier = Modifier.fillMaxWidth(),
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Number
                )
            )
            Spacer(modifier = Modifier.height(12.dp))

            TextField(value = productPrice,
                onValueChange = {
                    productPrice = it
                },
                label = { Text(text = "Product price") },
                modifier = Modifier.fillMaxWidth(),
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Decimal
                )
            )
            Spacer(modifier = Modifier.height(12.dp))

            Button(onClick = {
                try {
                    val id = productId.toInt()
                    val price = productPrice.toFloat()
                    rememberOpenCartScreen(id, productName, price)
                } catch (_: Exception) {

                }
            }) {
                Text("Buy")
            }
        }
    }
}