package com.fatherofapps.demojnav.ui.screen.address

import android.annotation.SuppressLint
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.unit.dp
import com.fatherofapps.demojnav.data.Address
import com.fatherofapps.jnav.annotations.JNav

@OptIn(ExperimentalMaterial3Api::class)
@Composable
@JNav(
    name = "AddressBookNavigation",
    baseRoute = "address_book_route",
    destination = "address_book_destination",
)
fun AddressBookScreen(
    openAddressDetailScreen: (Address) -> Unit,
) {

    val rememberOpenAddressDetailScreen = remember {
        { address: Address ->
            openAddressDetailScreen(address)
        }
    }

    val listAddresses = listOf(
        Address(id = 1, street = "Hoang Quoc Viet", phone = "099999999"),
        Address(id = 2, street = "Hoang Hoa Tham", phone = "88888888888")
    )

    Scaffold(topBar = {
        CenterAlignedTopAppBar(
            title = {
                Text(text = "Cart")
            },
            modifier = Modifier.shadow(elevation = 6.dp)
        )
    }) {padding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp, vertical = padding.calculateTopPadding()),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            items(listAddresses) { address ->
                Column(modifier = Modifier
                    .fillMaxWidth()
                    .clickable {
                        rememberOpenAddressDetailScreen(address)
                    }) {
                    Text("ID: ${address.id}")
                    Spacer(modifier = Modifier.height(6.dp))
                    Text("Street: ${address.street}")
                    Spacer(modifier = Modifier.height(6.dp))
                    Text("Street: ${address.street}")
                    Spacer(modifier = Modifier.height(6.dp))
                }
            }
        }
    }

}

