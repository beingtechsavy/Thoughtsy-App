package com.example.thoughtsy

import Data.wishDatabase
import Data.wishRepository
import android.content.Context
import androidx.room.Room

object Graph {
    lateinit var database: wishDatabase
    val wishRepository by lazy {
        wishRepository(wishDAO = database.wishDao())
    }

    fun provide(context: Context) {
        database = Room.databaseBuilder(
            context,
            wishDatabase::class.java,
            "wishList.db"
        ).build()
    }
}