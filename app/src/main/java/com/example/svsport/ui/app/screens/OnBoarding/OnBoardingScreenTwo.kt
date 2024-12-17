package com.example.svsport.ui.app.screens.OnBoarding

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.svsport.R
import com.example.svsport.ui.app.CustomUI.CustomButtonOnBoarding
import com.example.svsport.ui.theme.MainOnBoarding
import com.example.svsport.ui.theme.MinorOnBoarding
import com.example.svsport.ui.theme.Pink
import com.example.svsport.ui.theme.Purple
import com.example.svsport.ui.theme.Strings
import kotlin.math.sin


@Composable
fun OnBoardingScreenTwo(

    onNavigateToOneBoardingThree: () -> Unit

) {

    Surface(modifier = Modifier.fillMaxSize(), color = Color.White) {

        Column(modifier = Modifier.fillMaxSize()) {

            Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.TopCenter) {
                val waveHeight = 100f
                val waveLength = 100f
                val brush = Brush.horizontalGradient(listOf(Pink, Purple))

                Canvas(modifier = Modifier.matchParentSize()) {
                    val width = size.width
                    val height = size.height

                    val wavePath = androidx.compose.ui.graphics.Path().apply {
                        moveTo(0f, height / 2)
                        for (x in 0..width.toInt() step 3) {
                            val y = (height / 7) + (waveHeight * sin(0.2 * Math.PI * x / waveLength).toFloat())
                            lineTo(x.toFloat(), y)
                        }
                    }

                    val aboveWavePath = androidx.compose.ui.graphics.Path().apply {
                        moveTo(0f, height / 10)
                        for (x in 0..width.toInt() step 3) {
                            val y = (height / 3) + (waveHeight * sin(0.2 * Math.PI * x / waveLength).toFloat())
                            lineTo(x.toFloat(), y)
                        }
                        lineTo(width, 0f)
                        lineTo(0f, 0f)
                        close()
                    }

                    drawPath(path = aboveWavePath, brush)

                    drawPath(path = wavePath, color = Color.Transparent, style = Stroke(width = 10f))
                }


                Image(

                    modifier = Modifier
                        .padding(top = 50.dp),

                    painter = painterResource(id = R.drawable.runner),
                    contentDescription = ""

                )

            }

            Spacer(modifier = Modifier.height(64.dp))

            Column(

                modifier = Modifier
                    .padding(horizontal = 30.dp),

                verticalArrangement = Arrangement.spacedBy(15.dp)

            ) {

                Text(

                    text = "Track Your Goal",
                    style = MaterialTheme.typography.MainOnBoarding

                )

                Text(

                    text = Strings.minorTextScreenOne,
                    style = MaterialTheme.typography.MinorOnBoarding

                )

            }

            var progress by remember { mutableStateOf(0.33f)}

            Box(

                modifier = Modifier
                    .padding(horizontal = 30.dp)
                    .padding(bottom = 40.dp)
                    .fillMaxSize(),

                contentAlignment = Alignment.BottomEnd

            ) {

                CustomButtonOnBoarding(

                    progress = progress,
                    click = {

                        onNavigateToOneBoardingThree()

                        if (progress < 1) progress += 0.33f

                    }

                )
                    


            }

        }

    }

}

@Composable
@Preview(showBackground = true)
private fun OnBoardingScreenTwoPreview() {

    OnBoardingScreenTwo(onNavigateToOneBoardingThree = {})

}