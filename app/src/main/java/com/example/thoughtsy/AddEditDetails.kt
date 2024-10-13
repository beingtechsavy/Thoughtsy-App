package com.example.thoughtsy


import Data.wish
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.rememberScaffoldState
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import kotlinx.coroutines.launch

@Composable
fun AddEditDetails(
    id: Long,
    viewModel: WishViewModel,
    navHostController: NavHostController,
) {
    val snackMessage = remember {
        mutableStateOf("")
    }

    val scope = rememberCoroutineScope()

    val scaffoldState = rememberScaffoldState()
    if (id != 0L) {
        val wish = viewModel.getwishbyId(id).collectAsState(
            initial = wish(0L, "", "")
        )
        viewModel.wishtitlestate = wish.value.title
        viewModel.descriptionstate = wish.value.Description
    } else {
        viewModel.wishtitlestate = ""
        viewModel.descriptionstate = ""
    }

    androidx.compose.material.Scaffold(
        backgroundColor = colorResource(id = R.color.RoyalBlue),
        scaffoldState = scaffoldState,
        topBar = {
            Appbarview(
                titles =
                if (id != 0L) stringResource(id = R.string.update_wish) else stringResource(
                    id = R.string.add_wish
                )
            ) {
                navHostController.navigateUp()
            }
        }) {


        Column(
            modifier = Modifier
                .wrapContentSize()
                .padding(it)
                .padding(20.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top

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
                onvalueChanged = {
                    viewModel.ondescriptionChange(
                        it
                    )
                }
            )
            Spacer(
                modifier = Modifier.height(16.dp)
            )
            Button(
                onClick = {
                    if (viewModel.wishtitlestate.isNotEmpty() && viewModel.descriptionstate.isNotEmpty()) {
                        //TODO Update List
                        //TODO Add WIsh
                        if (id != 0L) {
                            viewModel.updateWish(
                                wish(
                                    id = id,
                                    title = viewModel.wishtitlestate.trim(),
                                    Description = viewModel.descriptionstate.trim()
                                )
                            )
                        } else {
                            viewModel.addWish(
                                wish(
                                    title = viewModel.wishtitlestate.trim(),
                                    Description = viewModel.descriptionstate.trim()
                                )
                            )
                            snackMessage.value = "Wish has been Added"
                        }


                    } else {
                        //Enter field to create a wish
                        snackMessage.value =
                            "Enter fields to create a wish"

                    }
//                    // go to the main screen.
                    scope.launch {
//                        scaffoldState.snackbarHostState.showSnackbar(snackMessage.value)
                        navHostController.navigateUp()
                    }
                }, colors = ButtonDefaults.buttonColors(
                    containerColor = colorResource(
                        id = R.color.Gold
                    )
                )
            ) {
                Text(
                    text = if (id != 0L) stringResource(id = R.string.update_wish) else stringResource(
                        id = R.string.add_wish
                    ), fontSize = 18.sp, color = colorResource(
                        id = R.color.white
                    )
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
            unfocusedTextColor = Color.DarkGray,
            focusedBorderColor = colorResource(id = R.color.PaleGold),
            focusedTextColor = colorResource(id = R.color.black),
            containerColor = colorResource(id = R.color.white),
            focusedLabelColor = colorResource(id = R.color.white), // Add focused label color
//            unfocusedLabelColor = colorResource(id = R.color.gray)    // Add unfocused label color
        )
    )

}

//@Preview
//@Composable
//fun Wishtest() {
//    WishTextModel(
//        label = "title",
//        value = "Shoes",
//        onvalueChanged = {})
//}
