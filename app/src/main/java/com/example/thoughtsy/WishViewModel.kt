package com.example.thoughtsy

import Data.wish
import Data.wishRepository
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class WishViewModel(private val wishRepository: wishRepository = Graph.wishRepository) :
    ViewModel() {
    var wishtitlestate by mutableStateOf("")
    var descriptionstate by mutableStateOf("")
    fun ontitleChange(newString: String) {
        wishtitlestate = newString
    }

    fun ondescriptionChange(newString: String) {
        descriptionstate = newString
    }

    lateinit var getAllWishes: Flow<List<wish>>

    init {
        viewModelScope.launch {
            getAllWishes = wishRepository.getwishes()
        }
    }

    fun addWish(wish: wish) {
        viewModelScope.launch(Dispatchers.IO) {
            wishRepository.addAwish(wish = wish)
        }
    }

    fun updateWish(wish: wish) {
        viewModelScope.launch(Dispatchers.IO) {
            wishRepository.updatewish(wish = wish)
        }
    }

    fun getwishbyId(id: Long): Flow<wish> {
        return wishRepository.getawish(id)
    }

    fun deletewish(wish: wish) {
        viewModelScope.launch(Dispatchers.IO) {
            wishRepository.deleteawish(wish = wish)
        }
    }

}