package com.example.thoughtsy

sealed class Screen(val route: String) {
    object HomeScreen : Screen("HomeScreen")
    object SecondScreen : Screen("SecondScreen")
}