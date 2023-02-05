package com.nameisjayant.starbucksapp.common

import android.annotation.SuppressLint
import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.nameisjayant.starbucksapp.ui.theme.LightGray

@SuppressLint("ModifierParameter")
@Composable
fun AppIcon(
    @DrawableRes icon: Int,
    tint: Color = Color.Unspecified,
     modifier: Modifier = Modifier,
    background:Color = LightGray
) {

    Box(
        modifier = modifier
            .size(46.dp)
            .clip(CircleShape)
            .background(background),
        contentAlignment = Alignment.Center
    ) {
        Icon(
            painter = painterResource(id = icon), contentDescription = "",
            tint = tint,
            modifier = Modifier.size(20.dp)
        )
    }

}