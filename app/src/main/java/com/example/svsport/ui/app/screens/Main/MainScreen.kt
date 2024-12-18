package com.example.svsport.ui.app.screens.Main

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draganddrop.DragAndDropModifierNode
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.svsport.R
import com.example.svsport.ui.app.CustomUI.CustomIndexMass
import com.example.svsport.ui.theme.AuthMainText
import com.example.svsport.ui.theme.AuthMinorText
import com.example.svsport.ui.theme.MinorAuth

@Composable
fun MainScreen(

    weight: String,
    height: String

) {

    Log.d("MainScreen", "Received weight: $weight, Received height: $height")

    val weightFloat = weight.toFloatOrNull()
    val heightFloat = height.toFloatOrNull()

    if (weightFloat == 0f || heightFloat == 0f) {
        Log.d("MainScreen", "Некорректные данные: вес = $weight, рост = $height")
    }

    Log.d("MainScreen", "Received weight: $weight, Received height: $height")

    Log.d("MainScreen", "WeightFloat: $weightFloat, HeightFloat: $heightFloat")

    if (weightFloat == null || heightFloat == null || weightFloat <= 0f || heightFloat <= 0f) {
        return Surface(
            modifier = Modifier.fillMaxSize(),
            color = Color.White
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = 40.dp)
                    .padding(horizontal = 30.dp)
            ) {
                Text(
                    text = "Некорректные данные для расчета ИМТ.",
                    style = MaterialTheme.typography.AuthMainText,
                    color = Color.Red
                )
            }
        }
    }

    val heightM = heightFloat?.div(100) ?: 0f

    Log.d("MainScreen", "Height in meters: $heightM")

    val bmi = if (weightFloat != null && heightM > 0f) {
        weightFloat / (heightM * heightM)
    } else {
        0f
    }

    val bmiFormatted = "%.1f".format(bmi)

    Log.d("MainScreen", "Calculated BMI: $bmiFormatted")

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

                    painter = painterResource(id = R.drawable.bell),
                    contentDescription = ""

                )

            }
            
            Spacer(modifier = Modifier.height(30.dp))

            CustomIndexMass(90f,)

            Text(

                text = bmiFormatted,
                style = MaterialTheme.typography.AuthMainText

            )

        }

    }

}

@Composable
@Preview(showBackground = true)
private fun MainScreenPreview() {

    MainScreen(weight = "90", height = "180")

}