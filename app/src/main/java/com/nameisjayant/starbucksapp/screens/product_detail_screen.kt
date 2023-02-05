package com.nameisjayant.starbucksapp.screens

import android.media.audiofx.AudioEffect.Descriptor
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Alignment.Companion.TopEnd
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.nameisjayant.starbucksapp.R
import com.nameisjayant.starbucksapp.common.AppIcon
import com.nameisjayant.starbucksapp.ui.theme.*


@Composable
fun ProductDetailScreen(
    navHostController: NavHostController
) {

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Background)
    ) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp)
        ) {
            ProductHeader(navHostController)
            LazyColumn {
                item {
                    ShowProduct()
                }
                item {
                    ProductDescription()
                }
            }
        }
        AppButton(
            modifier = Modifier
                .padding(20.dp)
                .align(Alignment.BottomCenter)
        )

    }

}

@Composable
fun ProductDescription(
    modifier: Modifier = Modifier
) {

    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 15.dp)
    ) {
        Text(
            text = "Coffee",
            style = TextStyle(
                color = DarkGreen,
                fontWeight = FontWeight.W400,
                fontSize = 18.sp,
                fontFamily = MediumFont
            ),
        )

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "Chocolate Frappuccino",
                style = TextStyle(
                    color = Color.Black,
                    fontWeight = FontWeight.W500,
                    fontSize = 22.sp,
                    fontFamily = MediumFont
                ),
            )
            Row(
                modifier = Modifier.align(CenterVertically)
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.star), contentDescription = "",
                    modifier = Modifier
                        .size(20.dp)
                        .align(CenterVertically),
                    tint = Color.Unspecified,
                )
                Spacer(modifier = Modifier.width(5.dp))
                Text(
                    text = "4.5",
                    style = TextStyle(
                        color = Gray400,
                        fontWeight = FontWeight.W400,
                        fontSize = 18.sp,
                        fontFamily = MediumFont
                    ),
                )
            }
        }
        Spacer(modifier = Modifier.height(15.dp))
        Text(
            text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Etiam at mi vitae augue feugiat scelerisque in a eros.",
            style = TextStyle(
                color = Gray500,
                fontWeight = FontWeight.W400,
                fontSize = 18.sp,
                fontFamily = MediumFont
            ),
        )
    }


}


@Composable
fun ShowProduct(
    modifier: Modifier = Modifier
) {
    var counter by remember { mutableStateOf(0) }
    Box(
        modifier = modifier
            .padding(top = 30.dp)
            .fillMaxWidth()
            .clip(RoundedCornerShape(14.dp))
            .background(LightRed),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 15.dp),
            horizontalAlignment = Alignment.CenterHorizontally

        ) {
            Image(
                painter = painterResource(id = R.drawable.image), contentDescription = "",
                modifier = Modifier.height(220.dp)
            )
            Spacer(modifier = Modifier.height(20.dp))

            Box(
                modifier = Modifier
                    .width(130.dp)
                    .clip(RoundedCornerShape(20.dp))
                    .background(Color.White)
            ) {
                AppIcon(icon = R.drawable.plus, background = DarkGreen) {
                    counter++
                }
                Spacer(modifier = Modifier.width(10.dp))
                Text(
                    text = "$counter",
                    style = TextStyle(
                        color = DarkGreen,
                        fontWeight = FontWeight.W400,
                        fontSize = 25.sp,
                        fontFamily = MediumFont
                    ),
                    modifier = Modifier.align(Center)
                )
                Spacer(modifier = Modifier.width(10.dp))
                AppIcon(
                    icon = R.drawable.minus, background = DarkGreen, modifier = Modifier.align(
                        TopEnd
                    )
                ) {
                    if (counter > 0)
                        counter--
                }
            }
        }
    }

}

@Composable
fun AppButton(
    modifier: Modifier = Modifier
) {

    Button(
        onClick = {}, modifier = modifier.fillMaxWidth(),
        elevation = ButtonDefaults.elevation(0.dp),
        shape = RoundedCornerShape(37.dp),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = DarkGreen
        ),
    ) {
        Text(
            text = stringResource(R.string.add_to_bag),
            style = TextStyle(
                color = Color.White,
                fontWeight = FontWeight.W500,
                fontSize = 20.sp,
                fontFamily = MediumFont
            ),
            modifier = Modifier.padding(vertical = 5.dp)
        )
    }

}


@Composable
fun ProductHeader(
    navHostController: NavHostController
) {


    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 30.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        AppIcon(icon = R.drawable.back){
            navHostController.navigateUp()
        }
        Icon(
            painter = painterResource(id = R.drawable.logo),
            contentDescription = "",
            modifier = Modifier.size(58.dp),
            tint = Color.Unspecified
        )
        AppIcon(icon = R.drawable.love)
    }

}
