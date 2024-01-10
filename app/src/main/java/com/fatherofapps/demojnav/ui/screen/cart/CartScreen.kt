package com.fatherofapps.demojnav.ui.screen.cart

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material3.Button
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.unit.dp
import com.fatherofapps.jnav.annotations.JNav
import com.fatherofapps.jnav.annotations.JNavArg

@OptIn(ExperimentalMaterial3Api::class)
@Composable
@JNav(
    name = "CartScreenNavigation",
    baseRoute = "cart_route",
    destination = "cart_destination",
    arguments = [
        JNavArg(name = "productName", type = String::class),
        JNavArg(name = "productId", type = Int::class),
        JNavArg(name = "productPrice", type = Float::class)
    ]
)
fun CartScreen(
    productName: String,
    productId: Int,
    productPrice: Float
) {

    Scaffold(topBar = {
        CenterAlignedTopAppBar(
            title = {
                Text(text = "Cart")
            }, modifier = Modifier.shadow(elevation = 6.dp)
        )
    }) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp, vertical = padding.calculateTopPadding())
        ) {

            Spacer(modifier = Modifier.height(24.dp))
            Text(text = "Product ID: $productId")
            Spacer(modifier = Modifier.height(12.dp))
            Text(text = "Product name: $productName")
            Spacer(modifier = Modifier.height(12.dp))
            Text(text = "Product price: $productPrice")
            Spacer(modifier = Modifier.height(24.dp))
            Button(onClick = { }) {
                Text("Checkout")
            }

        }
    }

}