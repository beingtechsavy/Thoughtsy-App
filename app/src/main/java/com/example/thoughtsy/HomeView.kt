package com.example.thoughtsy

import Data.wish
import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.DismissDirection
import androidx.compose.material.DismissValue
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.FractionalThreshold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun HomeView(navController: NavController, viewModel: WishViewModel) {
    val context =
        LocalContext.current
    Scaffold(
        containerColor = colorResource(id = R.color.RoyalBlue),
        topBar = {
            Appbarview(titles = "Thoughtsy") {

            }
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    // Add Navitgation

                    navController.navigate(Screen.SecondScreen.route + "/0L")


//                    Toast.makeText(
//                        context,
//                        "Button Worked",
//                        Toast.LENGTH_SHORT
//                    ).show()
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
        val wishlist =
            viewModel.getAllWishes.collectAsState(initial = listOf())
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
        ) {
            items(wishlist.value, key = { wish -> wish.id }) { wish ->
                val dismissState =
                    androidx.compose.material.rememberDismissState(
                        confirmStateChange = {
                            if (it == DismissValue.DismissedToEnd) {
                                viewModel.deletewish(wish)
                            }
                            true
                        }
                    )
                androidx.compose.material.SwipeToDismiss(
                    state = dismissState,
                    background = {
                        val color by animateColorAsState(
                            if (dismissState.dismissDirection == DismissDirection.StartToEnd) colorResource(
                                id = R.color.PaleGold
                            ) else Color.Transparent,
                            label = ""
                        )
                        val alignment = Alignment.CenterStart
                        Box(
                            modifier = Modifier
                                .fillMaxSize()
                                .background(color)
                                .padding(horizontal = 20.dp),
                            contentAlignment = alignment
                        ) {
                            Icon(
                                imageVector = Icons.Default.Delete,
                                contentDescription = null,
                                tint = Color.White
                            )
                        }
                    },
                    directions = setOf(DismissDirection.StartToEnd),
                    dismissThresholds = { FractionalThreshold(0.25f) },
                    dismissContent = {
                        WishItem(wish = wish) {
                            val id = wish.id
                            navController.navigate(Screen.SecondScreen.route + "/$id")
                        }
                    }
                )
//                WishItem(wish = wish) {
//                   val id= wish.id
//                    navController.navigate(Screen.SecondScreen.route+"/$id")
//                }
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


