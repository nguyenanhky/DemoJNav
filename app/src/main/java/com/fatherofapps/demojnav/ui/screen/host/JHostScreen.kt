package com.fatherofapps.demojnav.ui.screen.host

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.fatherofapps.demojnav.data.Address
import com.fatherofapps.demojnav.data.AddressNavType
import com.fatherofapps.demojnav.ui.screen.address.AddressBookNavigation
import com.fatherofapps.demojnav.ui.screen.address.AddressBookScreen
import com.fatherofapps.demojnav.ui.screen.address.AddressDetailNavigation
import com.fatherofapps.demojnav.ui.screen.address.AddressDetailScreen
import com.fatherofapps.demojnav.ui.screen.cart.CartScreen
import com.fatherofapps.demojnav.ui.screen.cart.CartScreenNavigation
import com.fatherofapps.demojnav.ui.screen.home.HomeNavigation
import com.fatherofapps.demojnav.ui.screen.home.HomeScreen

@Composable
fun JHostScreen() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = HomeNavigation.route) {

        composable(route = HomeNavigation.route) {
            HomeScreen(openCartScreen = { productId, productName, productPrice ->

                navController.navigate(
                    CartScreenNavigation.createRoute(
                        productName,
                        productId,
                        productPrice
                    )
                )

            }, openAddressBook = {
                navController.navigate(AddressBookNavigation.route)
            })
        }


        composable(
            route = CartScreenNavigation.route,
            arguments = CartScreenNavigation.arguments()
        ) {
            val productName = CartScreenNavigation.productName(it)
            val productId = CartScreenNavigation.productId(it)
            val productPrice = CartScreenNavigation.productPrice(it)
            CartScreen(
                productName = productName,
                productId = productId,
                productPrice = productPrice
            )
        }

        composable(route = AddressBookNavigation.route) {
            AddressBookScreen(openAddressDetailScreen = { address ->

                navController.navigate(AddressDetailNavigation.createRoute(address = address))

            })
        }

        composable(
            route = AddressDetailNavigation.route,
            arguments = AddressDetailNavigation.arguments()
        ) {
            val address = AddressDetailNavigation.address(it)
            AddressDetailScreen(address = address)
        }

    }
}