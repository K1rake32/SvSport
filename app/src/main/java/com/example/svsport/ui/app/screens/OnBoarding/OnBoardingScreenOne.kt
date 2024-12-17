package com.example.svsport.ui.app.screens.OnBoarding

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
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
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.scale
import androidx.compose.ui.graphics.drawscope.translate
import androidx.compose.ui.graphics.drawscope.withTransform
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


@Composable
fun OnBoardingScreenOne(

    onNavigateToOneBoardingTwo: () -> Unit

) {

    var progress by remember { mutableStateOf(0f)}

    Surface(modifier = Modifier.fillMaxSize()) {

        Column(

            modifier = Modifier
                .background(Color.White)
                .fillMaxSize(),

            horizontalAlignment = Alignment.Start

        ) {

            Spacer(modifier = Modifier.height(90.dp))

            Box(modifier = Modifier.fillMaxWidth()) {

                val brush = Brush.horizontalGradient(listOf(Pink, Purple))

                Canvas(modifier = Modifier.matchParentSize()) {

                    withTransform({

                        scale(scaleX = 15f, scaleY = 20f)
                        translate(left = -10f, top = -31f)

                    }) {

                        drawCircle(
                            brush,
                            radius = 20.dp.toPx(),
                        )

                    }
                }

                Image(

                    painter = painterResource(id = R.drawable.man_1),
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

            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 30.dp)
                    .padding(bottom = 40.dp),

                contentAlignment = Alignment.BottomEnd
            ) {

                CustomButtonOnBoarding(

                    progress = progress,
                    click = {

                        onNavigateToOneBoardingTwo()

                        if(progress < 1f) {

                            progress += 0.33f

                        }

                    }

                )

            }



        }
    }
}


@Composable
@Preview(showBackground = true)
private fun OnBoardingScreenOnePreview() {

    OnBoardingScreenOne(onNavigateToOneBoardingTwo = {})

}