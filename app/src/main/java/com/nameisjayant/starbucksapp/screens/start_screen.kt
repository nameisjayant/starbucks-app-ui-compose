package com.nameisjayant.starbucksapp.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.nameisjayant.starbucksapp.R
import com.nameisjayant.starbucksapp.ui.theme.Background


@Composable
fun StartScreen() {

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