package com.example.thoughtsy

import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.material.IconButton
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.outlined.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp

@Composable
fun Appbarview(titles: String, BacktoHomeScreen: () -> Unit = {}) {

    val navicons: (@Composable () -> Unit)? = {
        if (!titles.contains("Thoughtsy")) {
            IconButton(onClick = { BacktoHomeScreen() }) {
                Icon(
                    imageVector = Icons.AutoMirrored.Outlined.ArrowBack,
                    contentDescription = "Back Icons",
                    tint = Color.White,
                )
            }
        } else {
            null
        }
    }


    TopAppBar(
        title = {
            Text(
                text = titles,
                color = Color.White,
                modifier = Modifier
                    .padding(start = 4.dp)
                    .heightIn(24.dp)
            )
        },
        elevation = 3.dp,
        backgroundColor = colorResource(id = R.color.RoyalBlue),
        navigationIcon = navicons
    )

}                                                                                                                                  