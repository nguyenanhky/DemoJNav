package com.fatherofapps.demojnav

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.fatherofapps.demojnav.data.Address
import com.fatherofapps.demojnav.data.AddressNavType
import com.fatherofapps.demojnav.ui.screen.address.AddressBookScreen
import com.fatherofapps.demojnav.ui.screen.address.AddressDetailScreen
import com.fatherofapps.demojnav.ui.screen.cart.CartNavigation
import com.fatherofapps.demojnav.ui.screen.cart.CartScreen
import com.fatherofapps.demojnav.ui.screen.home.HomeScreen
import com.fatherofapps.demojnav.ui.screen.host.JHostScreen
import com.fatherofapps.demojnav.ui.theme.DemoJNavTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DemoJNavTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    JHostScreen()
                }
            }
        }
    }
}

@Composable
fun HostScreen() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "home") {

        composable(route = "home") {
            HomeScreen(openCartScreen = { productId, productName, productPrice ->

                navController.navigate("cart/productId=$productId&productName=$productName&productPrice=$productPrice")

            }, openAddressBook = {
                navController.navigate("addressBook")
            })
        }


        composable(
            route = "cart/productId={productId}&productName={productName}&productPrice={productPrice}",
            arguments = listOf(
                navArgument("productId") {
                    type = NavType.IntType
                    nullable = false
                },
                navArgument("productName") {
                    type = NavType.StringType
                    nullable = false
                },
                navArgument("productPrice") {
                    type = NavType.FloatType
                    nullable = false
                },
            )
        ) {
            val productName = it.arguments?.getString("productName") ?: throw Exception("")
            val productId = it.arguments?.getInt("productId") ?: throw Exception("")
            val productPrice = it.arguments?.getFloat("productPrice") ?: throw Exception("")
            CartScreen(
                productName = productName,
                productId = productId,
                productPrice = productPrice
            )
        }

        composable(route = "addressBook") {
            AddressBookScreen(openAddressDetailScreen = { address ->

                navController.navigate("addressDetail&address=${address}")

            })
        }

        composable(route = "addressDetail&address={address}", arguments = listOf(
            navArgument("address") {
                type = AddressNavType()
                nullable = false
            }
        )) {
            val address = it.arguments?.getParcelable<Address>("address") ?: throw Exception("")
            AddressDetailScreen(address = address)
        }

    }
}