package com.example.thoughtsy

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController

@Composable
fun SecondView(
    id: Long,
    viewModel: WishViewModel,
    navHostController: NavHostController,
) {
    Scaffold(topBar = {
        Appbarview(
            titles =
            if (id != 0L) stringResource(id = R.string.update_wish) else stringResource(
                id = R.string.add_wish
            )
        )
    }) {
        Column(
            modifier = Modifier
                .wrapContentSize()
                .padding(it)
                .padding(20.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Spacer(
                modifier = Modifier.height(16.dp)
            )
            WishTextModel(
                label = "title",
                value = viewModel.wishtitlestate,
                onvalueChanged = { viewModel.ontitleChange(it) }
            )
            Spacer(
                modifier = Modifier.height(16.dp)
            )
            WishTextModel(
                label = "description",
                value = viewModel.descriptionstate,
                onvalueChanged = { viewModel.ondescriptionChange(it) }
            )
            Spacer(
                modifier = Modifier.height(16.dp)
            )
            Button(onClick = {
                if (viewModel.wishtitlestate.isNotEmpty() && viewModel.descriptionstate.isNotEmpty()) {
                    //TODO Update List
                } else {
                    //TODO ADD LIST

                }
            }) {
                Text(
                    text = if (id != 0L) stringResource(id = R.string.update_wish) else stringResource(
                        id = R.string.add_wish
                    ), fontSize = 18.sp
                )
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WishTextModel(
    label: String,
    value: String,
    onvalueChanged: (String) -> Unit,

    ) {


    OutlinedTextField(
        value = value,
        onValueChange = onvalueChanged,
        label = { Text(text = label) },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = colorResource(id = R.color.PaleGold),

            containerColor = colorResource(id = R.color.white),
            focusedLabelColor = colorResource(id = R.color.PaleGold), // Add focused label color
//            unfocusedLabelColor = colorResource(id = R.color.gray)    // Add unfocused label color
        )
    )

}

@Preview
@Composable
fun Wishtest() {
    WishTextModel(
        label = "title",
        value = "Shoes",
        onvalueChanged = {})
}
