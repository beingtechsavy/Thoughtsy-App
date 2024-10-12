package com.example.thoughtsy

import Data.DummyList
import Data.wish
import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun HomeView() {
    val context =
        LocalContext.current
    Scaffold(
        containerColor = colorResource(id = R.color.RoyalBlue),
        topBar = {
            Appbarview(titles = "Thoughtsy") {
                Toast.makeText(
                    context,
                    "Button Worked",
                    Toast.LENGTH_SHORT
                ).show()
            }
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    // Add Navitgation
                    Toast.makeText(
                        context,
                        "Button Worked",
                        Toast.LENGTH_SHORT
                    ).show()
                }, modifier = Modifier.padding(20.dp),
                contentColor = Color.White,
                containerColor = colorResource(id = R.color.Gold)
            ) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = null
                )
            }
        }) {

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
        ) {
            items(DummyList.wishlist) { it ->
                WishItem(wish = it) {
                    Toast.makeText(
                        context,
                        "Click worked",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }


    }
}


@Composable
fun WishItem(wish: wish, onClick: () -> Unit) {

    Card(
        modifier = Modifier
            .padding(top = 8.dp, start = 8.dp, end = 8.dp)
            .fillMaxWidth()
            .clickable {
                onClick()
            },
        elevation = CardDefaults.cardElevation(16.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White // Use a contrasting color
        )
//                        colors =CardDefaults.cardColors( colorResource(
//                            id = R.color.RoyalBlue
//                        )                               )
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(
                text = wish.title,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )
            Text(text = wish.Description, color = Color.Black)

        }
    }


}


