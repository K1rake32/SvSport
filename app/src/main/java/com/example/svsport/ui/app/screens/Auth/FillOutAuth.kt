package com.example.svsport.ui.app.screens.Auth

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.translate
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.svsport.R
import com.example.svsport.ui.app.CustomUI.CustomAuthInput
import com.example.svsport.ui.app.CustomUI.CustomComponentAuth
import com.example.svsport.ui.app.CustomUI.CustomNextButton
import com.example.svsport.ui.app.Dialog.GenderDialog
import com.example.svsport.ui.theme.AuthMainText
import com.example.svsport.ui.theme.AuthMinorText
import com.example.svsport.ui.theme.Gray
import com.example.svsport.ui.theme.InputAuthText
import com.example.svsport.ui.theme.Pink
import com.example.svsport.ui.theme.Purple
import com.example.svsport.ui.theme.brush

@Composable
fun FillOutAuth(

    onNavigateToMainScreen: (String, String) -> Unit,
    onNavigateToProfileScreen: (String, String) -> Unit


) {

    val weight = remember { mutableStateOf("") }
    val height = remember { mutableStateOf("")}

    val openAlert = remember {

        mutableStateOf(false)

    }

    val selectedGender = remember { mutableStateOf("Choose Gender")}



    Surface(

        modifier = Modifier
            .fillMaxSize(),

        color = Color.White

    ) {

        Column(

            modifier = Modifier
                .fillMaxSize()

        ) {

            Box(

                modifier = Modifier
                    .fillMaxWidth(),

                contentAlignment = Alignment.TopCenter

            ) {

                val brush = Brush.linearGradient(listOf(Purple, Pink))

                Canvas(modifier = Modifier.matchParentSize()) {

                        translate(left = 0f, top = 70f) {

                            drawCircle(brush, radius = 150.dp.toPx())

                    }

                }

                Image(

                    modifier = Modifier
                        .padding(top = 62.dp),

                    painter = painterResource(id = R.drawable.onboardng_tree),
                    contentDescription = ""

                )

            }

            Spacer(modifier = Modifier.height(50.dp))

            Column(

                modifier = Modifier
                    .fillMaxWidth(),

                verticalArrangement = Arrangement.spacedBy(5.dp),
                horizontalAlignment = Alignment.CenterHorizontally

            ) {

                Text(

                    modifier = Modifier
                        .clickable { openAlert.value = true },

                    text = "Let’s complete your profile",
                    style = MaterialTheme.typography.AuthMainText

                )

                Text(

                    text = "It will help us to know more about you!",
                    style = MaterialTheme.typography.AuthMinorText

                )

            }

            Spacer(modifier = Modifier.height(30.dp))

            Column(

                modifier = Modifier
                    .padding(horizontal = 40.dp)
                    .fillMaxWidth(),

                verticalArrangement = Arrangement.spacedBy(15.dp),
                horizontalAlignment = Alignment.Start

            ) {

                Box(

                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(15.dp))
                        .background(Gray)
                        .clickable { openAlert.value = true }

                ) {

                    if (openAlert.value) {

                        GenderDialog(openDialog = openAlert, onGenderSelected  = { gender ->
                            selectedGender.value = gender
                        })

                    }

                    Row(

                        modifier = Modifier
                            .padding(horizontal = 15.dp)
                            .padding(vertical = 20.dp)
                            .fillMaxWidth(),

                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically

                    ) {

                        Row(

                            horizontalArrangement = Arrangement.spacedBy(10.dp),
                            verticalAlignment = Alignment.CenterVertically

                        ) {

                            Image(

                                painter = painterResource(id = R.drawable.gender),
                                contentDescription = ""

                            )

                            Text(

                                text = selectedGender.value,
                                style = MaterialTheme.typography.InputAuthText

                            )

                        }

                        Image(

                            painter = painterResource(id = R.drawable.choose),
                            contentDescription = ""

                        )

                    }

                }

                CustomAuthInput(

                    image = R.drawable.calendar,
                    label = "Date of Birth",
                    onValueChange = { /*TODO*/ }

                )

                Row(

                    modifier = Modifier.fillMaxWidth(),

                    horizontalArrangement = Arrangement.SpaceBetween

                ) {

                    CustomAuthInput(

                        image = R.drawable.weigth,
                        label = "Your Weight",
                        onValueChange = { weight.value = it},
                        isMaxWidth = false,
                        width = 240.dp,
                        isInt = true

                    )

                    CustomComponentAuth(text = "KG")

                }

                Row(

                    modifier = Modifier.fillMaxWidth(),

                    horizontalArrangement = Arrangement.SpaceBetween

                ){

                    CustomAuthInput(

                        image = R.drawable.height,
                        label = "Your Height",
                        onValueChange = { height.value = it },
                        isMaxWidth = false,
                        width = 240.dp,
                        isInt = true

                    )

                    CustomComponentAuth(text = "CM")

                }

            }

            Spacer(modifier = Modifier.height(30.dp))


            Box(modifier = Modifier.padding(horizontal = 40.dp)) {

                CustomNextButton(

                    label = "Next",
                    onClick = {onNavigateToMainScreen(weight.value, height.value)},
                    brush

                )

            }

        }

    }

}

@Composable
@Preview(showBackground = true)
private fun FillOutAuthPreview() {

    FillOutAuth(onNavigateToMainScreen = { weight, height -> }, onNavigateToProfileScreen = { weight, height -> })

}