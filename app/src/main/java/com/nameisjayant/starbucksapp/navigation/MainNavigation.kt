package com.nameisjayant.starbucksapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.nameisjayant.starbucksapp.screens.HomeScreen
import com.nameisjayant.starbucksapp.screens.ProductDetailScreen
import com.nameisjayant.starbucksapp.screens.StartScreen


@Composable
fun MainNavigation() {

    val navHostController = rememberNavController()

    NavHost(navController = navHostController, startDestination = SPLASH_SCREEN ){
        composable(SPLASH_SCREEN){
            StartScreen(navHostController)
        }
        composable(HOME_SCREEN){
            HomeScreen(navHostController)
        }
        composable(DETAIL_SCREEN){
            ProductDetailScreen(navHostController)
        }
    }

}

const val SPLASH_SCREEN = "splash_screen"
const val  HOME_SCREEN = "home_screen"
const val DETAIL_SCREEN = "detail_screen"