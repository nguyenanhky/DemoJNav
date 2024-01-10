package com.fatherofapps.demojnav.ui.screen.cart

import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavType
import androidx.navigation.navArgument

object CartNavigation {

    private const val productIdArg = "productIdArg"
    private const val productNameArg = "productNameArg"
    private const val productPriceArg = "productPriceArg"

    val route = "cart/$productIdArg={$productIdArg}&$productNameArg={$productNameArg}&$productPriceArg={$productPriceArg}"

    fun createRoute(
        productId:Int,
        productName:String,
        productPrice:Float
    ):String{
        return "cart/$productIdArg=$productId&$productNameArg=$productName&$productPriceArg=$productPrice"
    }

    fun productId(navBackStackEntry: NavBackStackEntry) = navBackStackEntry.arguments?.getInt("productId") ?: throw Exception("")

    fun productName(navBackStackEntry: NavBackStackEntry) = navBackStackEntry.arguments?.getString("productName") ?: throw Exception("")

    fun productPrice(navBackStackEntry: NavBackStackEntry) = navBackStackEntry.arguments?.getFloat("productPrice") ?: throw Exception("")

    fun arguments() = listOf(
        navArgument(productIdArg){
            type = NavType.IntType
            nullable = false
        },
        navArgument(productNameArg){
            type = NavType.StringType
            nullable = false
        },
        navArgument(productPriceArg){
            type = NavType.FloatType
            nullable = false
        },
    )
}