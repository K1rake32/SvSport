package com.example.svsport.ui.app.BottomNavigation

import androidx.compose.foundation.Image
import androidx.compose.foundation.Indication
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.indication
import androidx.compose.foundation.interaction.Interaction
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.absoluteOffset
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.ParagraphIntrinsics
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.svsport.R
import com.example.svsport.ui.app.Navigation.Screen
import com.example.svsport.ui.theme.Gray
import com.example.svsport.ui.theme.GrayWhite
import com.example.svsport.ui.theme.Pink
import com.example.svsport.ui.theme.PinkButton
import com.example.svsport.ui.theme.Purple
import com.example.svsport.ui.theme.PurpleButton
import com.example.svsport.ui.theme.brush

@Composable
fun BottomNavigation(navController: NavController, weight: String, height: String) {

    val items = listOf(

        BottomData(

            title = "Home",
            selectedImg = R.drawable.home_fill,
            unSelectedImg = R.drawable.home_bar,

            ),

        BottomData(

            title = "Activity",
            selectedImg = R.drawable.activity_fill,
            unSelectedImg = R.drawable.activity_bar,

            ),

        BottomData(

            title = "Search",
            selectedImg = R.drawable.search_bar,
            unSelectedImg = R.drawable.search_bar,

            ),

        BottomData(

            title = "Camera",
            selectedImg = R.drawable.camera_fill,
            unSelectedImg = R.drawable.camera_bar,

            ),

        BottomData(

            title = "Profile",
            selectedImg = R.drawable.profile_fill,
            unSelectedImg = R.drawable.profile_bar,

            ),

        )

    var selectedItemIndex by rememberSaveable {
        mutableStateOf(0)
    }


    Box {

    NavigationBar(

        containerColor = Color.White,

        ) {

        val brush = Brush.linearGradient(listOf(PurpleButton, PinkButton))

        items.forEachIndexed { index, item ->

            NavigationBarItem(

                selected = selectedItemIndex == index,
                onClick = {

                    selectedItemIndex = index

                    when (index) {

                        0 -> navController.navigate(Screen.MainScreen.createRoute(weight, height))
                        4 -> navController.navigate(
                            Screen.ProfileScreen.createRoute(
                                weight,
                                height
                            )
                        )

                    }

                },
                icon = {

                    if (index == 2) {

                        Box(

                            modifier = Modifier
                                .offset(y = (-26).dp)
                                .clip(CircleShape)
                                .background(brush)

                        )

                        {

                            Image(

                                modifier = Modifier
                                    .padding(22.dp),

                                painter = painterResource(id = item.selectedImg),
                                contentDescription = ""

                            )

                        }

                    } else

                        Box(

                            modifier = Modifier
                                .height(35.dp)

                        ) {

                            Image(

                                painter = painterResource(

                                    id = if (selectedItemIndex == index) {
                                        item.selectedImg
                                    } else item.unSelectedImg

                                ),

                                contentDescription = item.title,

                                )

                            if (selectedItemIndex == index) {

                                Box(

                                    modifier = Modifier
                                        .align(Alignment.BottomCenter)
                                        .clip(CircleShape)
                                        .size(8.dp)
                                        .background(brush)

                                )

                            }

                        }

                },

                colors = NavigationBarItemDefaults.colors(

                    indicatorColor = Color.White

                )

            )
        }

    }

        Box(

            modifier = Modifier
                .align(Alignment.Center)
                .offset(y = (-35).dp)
                .clip(CircleShape)
                .background(brush)

        )

        {

            Image(

                modifier = Modifier
                    .padding(22.dp),

                painter = painterResource(id = R.drawable.search_bar),
                contentDescription = ""

            )

        }

    }

}

@Composable
@Preview
private fun BottomNavigationPreview() {

    val navController = rememberNavController()

    BottomNavigation(navController = navController, weight = "90", height = "180")

}