package com.nameisjayant.starbucksapp.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.nameisjayant.starbucksapp.R
import com.nameisjayant.starbucksapp.navigation.HOME_SCREEN
import com.nameisjayant.starbucksapp.ui.theme.Background
import kotlinx.coroutines.delay


@Composable
fun StartScreen(
    navHostController: NavHostController
) {

    LaunchedEffect(key1 = true){
        delay(2000)
        navHostController.navigate(HOME_SCREEN)
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Background), contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.logo),
            contentDescription = "",
            modifier = Modifier.size(150.dp)
        )
    }

}