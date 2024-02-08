package com.example.selim_test

sealed class Screen(val route: String) {
    object Home : Screen("home")
    object Settings : Screen("settings")
    object Images : Screen("screen")
}



