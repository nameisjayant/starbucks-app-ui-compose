package com.nameisjayant.starbucksapp.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.nameisjayant.starbucksapp.common.AppIcon
import com.nameisjayant.starbucksapp.R
import com.nameisjayant.starbucksapp.ui.theme.*


@Composable
fun HomeScreen() {
    var search by remember { mutableStateOf("") }
    val menuList = listOf("All", "Coffee", "Tea", "Drinks", "Beer", "Wine")
    var selected by remember { mutableStateOf("All") }
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
            Header()
            LazyColumn {
                item {
                    Text(
                        text = "Our way of loving\nyou back", style = TextStyle(
                            fontSize = 25.sp,
                            color = Color.Black,
                            fontFamily = SemiboldFont,
                            fontWeight = FontWeight.W600
                        ),
                        modifier = Modifier.padding(vertical = 30.dp)
                    )
                }
                item {
                    Box() {
                        CustomSearchBar(value = search, onValueChange = { search = it })
                        AppIcon(
                            icon = R.drawable.filter,
                            background = DarkGreen,
                            modifier = Modifier
                                .align(
                                    Alignment.TopEnd
                                )
                                .size(55.dp)
                        )
                    }
                }
                item {
                    LazyRow(modifier = Modifier.padding(vertical = 20.dp)) {
                        items(menuList) {
                            CustomFilterChip(title = it, selected = it == selected) { data ->
                                selected = data

                            }
                        }
                    }
                }
                item {
                    Popular()
                }
            }
        }
    }
}

@Composable
fun Popular() {

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 10.dp, bottom = 20.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "Popular",
                style = TextStyle(
                    color = Color.Black,
                    fontWeight = FontWeight.W500,
                    fontSize = 22.sp,
                    fontFamily = MediumFont
                ),
            )
            Text(
                text = "See All",
                style = TextStyle(
                    color = DarkGreen,
                    fontWeight = FontWeight.W500,
                    fontSize = 22.sp,
                    fontFamily = MediumFont
                ),
            )
        }
        Spacer(modifier = Modifier.height(10.dp))
        LazyRow {
            items(5) {
                ItemEachRow()
            }
        }
    }

}

@Composable
fun ItemEachRow() {

    var selected by remember { mutableStateOf(false) }


    Card(
        shape = RoundedCornerShape(14.dp),
        modifier = Modifier
            .width(220.dp)
            .padding(end = 10.dp),
    ) {
        Column {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
                    .clip(
                        RoundedCornerShape(
                            bottomStart = 14.dp,
                            bottomEnd = 14.dp
                        )
                    )
                    .background(LightRed),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(id = R.drawable.image), contentDescription = "",
                    modifier = Modifier
                        .height(180.dp),
                )
            }
            Column(
                modifier = Modifier.padding(15.dp)
            ) {
                Text(
                    text = "Chocolate Frappuccino",
                    style = TextStyle(
                        color = DarkGray,
                        fontWeight = FontWeight.W500,
                        fontSize = 20.sp,
                        fontFamily = MediumFont
                    ),
                )
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = "$20.00",
                        style = TextStyle(
                            color = DarkGreen,
                            fontWeight = FontWeight.W400,
                            fontSize = 25.sp,
                            fontFamily = MediumFont
                        ),
                    )
                    IconButton(onClick = {
                        selected = !selected
                    }, modifier = Modifier.size(24.dp).align(CenterVertically)) {
                        Icon(
                            painter = painterResource(id = R.drawable.love),
                            contentDescription = "",
                            tint = if (selected) Red else Color.Unspecified
                        )
                    }

                }
            }


        }
    }

}

@Composable
fun CustomFilterChip(
    title: String,
    selected: Boolean,
    modifier: Modifier = Modifier,
    onValueChange: (String) -> Unit,

    ) {

    TextButton(
        onClick = { onValueChange(title) },
        shape = RoundedCornerShape(22.dp),
        elevation = ButtonDefaults.elevation(0.dp),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = if (selected) DarkGreen else Gray
        ),
        modifier = modifier.padding(end = 15.dp)
    ) {
        Text(
            text = title, style = TextStyle(
                color = if (selected) Color.White else TextColor,
                fontWeight = FontWeight.W400,
                fontSize = 20.sp,
                fontFamily = RegularFont
            ),
            modifier = Modifier.padding(vertical = 5.dp, horizontal = 10.dp)
        )
    }

}

@Composable
fun CustomSearchBar(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier
) {

    Box(
        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(26.5.dp))
            .background(Gray)
    ) {
        TextField(
            value = value, onValueChange = { onValueChange(it) },
            placeholder = {
                Text(
                    text = "Search", style = TextStyle(
                        fontSize = 16.sp,
                        fontFamily = RegularFont,
                        fontWeight = FontWeight.W400,
                        color = DarkGray
                    )
                )
            },
            leadingIcon = {
                Icon(
                    painter = painterResource(id = R.drawable.search),
                    contentDescription = "",
                    tint = Color.Unspecified
                )
            },
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = Color.Transparent,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent
            ),
            singleLine = true,
            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done),
            trailingIcon = {}
        )
    }

}

@Composable
fun Header() {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 30.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        AppIcon(icon = R.drawable.menu)
        Icon(
            painter = painterResource(id = R.drawable.logo),
            contentDescription = "",
            modifier = Modifier.size(58.dp),
            tint = Color.Unspecified
        )
        AppIcon(icon = R.drawable.bag)
    }

}