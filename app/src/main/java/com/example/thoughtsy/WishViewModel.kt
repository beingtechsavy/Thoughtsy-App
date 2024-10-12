package com.example.thoughtsy

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class WishViewModel : ViewModel() {
    var wishtitlestate by mutableStateOf("")
    var descriptionstate by mutableStateOf("")
    fun ontitleChange(newString: String) {
        wishtitlestate = newString
    }

    fun ondescriptionChange(newString: String) {
        descriptionstate = newString
    }
}