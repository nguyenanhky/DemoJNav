package com.fatherofapps.demojnav.ui.screen.address

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.unit.dp
import com.fatherofapps.demojnav.data.Address
import com.fatherofapps.demojnav.data.AddressNavType
import com.fatherofapps.jnav.annotations.JDataType
import com.fatherofapps.jnav.annotations.JNav
import com.fatherofapps.jnav.annotations.JNavArg

@OptIn(ExperimentalMaterial3Api::class)
@Composable
@JNav(
    name = "AddressDetailNavigation",
    baseRoute = "address_detail_route",
    destination = "address_detail_destination",
    arguments = [
        JNavArg(
            name = "address",
            type = Address::class,
            dataType = JDataType.Parcelable,
            customNavType = AddressNavType::class,
        )
    ]
)
fun AddressDetailScreen(address: Address) {
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
            Text(text = "Address ID: ${address.id}")
            Spacer(modifier = Modifier.height(12.dp))
            Text(text = "Address street: ${address.street}")
            Spacer(modifier = Modifier.height(12.dp))
            Text(text = "Address phone: ${address.phone}")
            Spacer(modifier = Modifier.height(12.dp))
        }
    }
}