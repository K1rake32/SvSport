package com.example.svsport.ui.app.screens.OnBoarding

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.svsport.ui.app.CustomUI.CustomNextButton
import com.example.svsport.ui.theme.MainWelcomeText
import com.example.svsport.ui.theme.MinorWelcomeText

@Composable
fun WelcomeScreen(

    onNavigateToOneBoardingOne: () -> Unit

) {

    Surface(

        modifier = Modifier
            .fillMaxSize(),

        color = Color.White

    ) {

        Column(

            modifier = Modifier
                .fillMaxSize(),

            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center

        ) {

            Text(

                text = "SvSport",
                style = MaterialTheme.typography.MainWelcomeText

            )
            
            Spacer(modifier = Modifier.height(6.dp))

            Text(

                text = "Everybody Can Train",
                style = MaterialTheme.typography.MinorWelcomeText

            )

        }

        Box(
            modifier = Modifier
                .padding(horizontal = 30.dp)
                .padding(bottom = 40.dp),

            contentAlignment = Alignment.BottomCenter

        ) {

            CustomNextButton(

                label = "Get Started",
                onClick = {onNavigateToOneBoardingOne()}

            )

        }

    }

}

@Composable
@Preview(showBackground = true)
private fun WelcomeScreenPreview() {

    WelcomeScreen(onNavigateToOneBoardingOne = {})

}


