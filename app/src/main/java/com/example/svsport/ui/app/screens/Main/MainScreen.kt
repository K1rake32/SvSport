package com.example.svsport.ui.app.screens.Main

import android.util.Log
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
import androidx.compose.material.icons.Icons
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draganddrop.DragAndDropModifierNode
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.svsport.R
import com.example.svsport.ui.app.CustomUI.CustomIndexMass
import com.example.svsport.ui.theme.AuthMainText
import com.example.svsport.ui.theme.AuthMinorText
import com.example.svsport.ui.theme.MinorAuth
import com.example.svsport.ui.theme.MinorComponentAuth
import com.example.svsport.ui.theme.Pink
import com.example.svsport.ui.theme.PinkButton
import com.example.svsport.ui.theme.Purple
import com.example.svsport.ui.theme.PurpleButton
import com.example.svsport.ui.theme.TodayTarget

@Composable
fun MainScreen(

    weight: String,
    height: String,

    onNavigateToProfile: () -> Unit,
    onNavigateToNotification: () -> Unit


) {

    val weightFloat = weight.toFloatOrNull()
    val heightFloat = height.toFloatOrNull()

    val heightM = heightFloat?.div(100) ?: 0f

    val bmi = if (weightFloat != null && heightM > 0f) {
        weightFloat / (heightM * heightM)
    } else {
        0f
    }

    val brush = Brush.linearGradient(listOf(PurpleButton, PinkButton))

    val bmiFormatted = "%.1f".format(bmi).replace(",", ".")

    Surface (

        modifier = Modifier
            .fillMaxSize(),

        color = Color.White

    ) {

        Column(

            modifier = Modifier
                .fillMaxSize()

                .padding(top = 40.dp)
                .padding(horizontal = 30.dp)

        ) {

            Row(

                modifier = Modifier
                    .fillMaxWidth(),

                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween

            ) {

                Column(

                    verticalArrangement = Arrangement.spacedBy(5.dp)

                ) {
                    
                    Text(

                        text = "Welcome Back,",
                        style = MaterialTheme.typography.AuthMinorText

                    )
                    
                    Text(

                        text = "Andrey Sviridovsky",
                        style = MaterialTheme.typography.AuthMainText

                    )

                }

                Image(

                    modifier = Modifier
                        .clickable { onNavigateToNotification() },

                    painter = painterResource(id = R.drawable.bell),
                    contentDescription = ""

                )

            }
            
            Spacer(modifier = Modifier.height(30.dp))

            val availableWeight = when {

                bmi <= 18 -> "under"
                bmi > 18 && bmi < 25  -> "normal"
                else -> "over"

            }

            CustomIndexMass(value = 360f, label = "You have a $availableWeight weight", iMT = bmiFormatted)

            Spacer(modifier = Modifier.height(30.dp))

            Box(

                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(16.dp))
                    .background(Pink.copy(alpha = 0.3f))

            ) {

                Row(

                    modifier = Modifier
                        .padding(vertical = 16.dp)
                        .padding(horizontal = 20.dp)
                        .fillMaxWidth(),

                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically

                ) {

                    Text(

                        text = "Today Target",
                        style = MaterialTheme.typography.TodayTarget

                    )

                    Box(

                        modifier = Modifier
                            .clip(RoundedCornerShape(50.dp))
                            .background(brush)


                    ) {

                        Text(

                            modifier = Modifier
                                .padding(horizontal = 15.dp)
                                .padding(vertical = 5.dp)
                                .clickable { onNavigateToProfile() },

                            text = "Check",
                            style = MaterialTheme.typography.MinorComponentAuth

                        )

                    }

                }

            }

        }

    }

}

@Composable
@Preview(showBackground = true)
private fun MainScreenPreview() {

    MainScreen(weight = "80", height = "180", {}, {})

}