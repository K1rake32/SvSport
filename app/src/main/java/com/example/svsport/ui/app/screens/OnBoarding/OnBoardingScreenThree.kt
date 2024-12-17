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
import androidx.compose.foundation.layout.wrapContentSize
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
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.svsport.R
import com.example.svsport.ui.app.CustomUI.CustomButtonOnBoarding
import com.example.svsport.ui.theme.MainOnBoarding
import com.example.svsport.ui.theme.MinorOnBoarding
import com.example.svsport.ui.theme.Pink
import com.example.svsport.ui.theme.Purple
import com.example.svsport.ui.theme.Strings
import com.example.svsport.ui.theme.brush
import kotlin.io.path.Path
import kotlin.io.path.moveTo

@Composable
fun OnBoardingScreenThree(

    onNavigateToAuthMain: () -> Unit

) {

    Surface(

        modifier = Modifier
            .fillMaxSize(),

        color = Color.White

    ) {

        Column(

            modifier = Modifier
                .fillMaxSize(),

            horizontalAlignment = Alignment.Start

        ) {

            Box(

                modifier = Modifier
                    .fillMaxWidth(),
                contentAlignment = Alignment.TopCenter

            ) {

                Canvas(modifier = Modifier.matchParentSize()) {

                    val brush = Brush.linearGradient(listOf(Pink, Purple))

                    val wavePath = androidx.compose.ui.graphics.Path().apply {
                        moveTo(0f, 0f)
                        lineTo(0f, size.height * 0.3f)
                        quadraticBezierTo(
                            size.width * 0.1f, size.height * 0.01f,
                            size.width * 0.25f, size.height * 0.2f
                        )
                        quadraticBezierTo(
                            size.width * 0.75f, size.height * 1f,
                            size.width, size.height * 1f
                        )
                        lineTo(size.width, 0f)
                        close()
                    }

                    drawPath(path = wavePath, brush = brush)

                }


                Image(

                    modifier = Modifier
                        .padding(top = 60.dp),

                    painter = painterResource(id = R.drawable.onboardng_tree),
                    contentDescription = ""

                )

            }

            Spacer(modifier = Modifier.height(180.dp))

            Column(

                modifier = Modifier
                    .padding(horizontal = 30.dp)
                    .fillMaxSize(),

                verticalArrangement = Arrangement.spacedBy(15.dp)
            ) {

                Text(

                    text = Strings.MainThreeOB,
                    style = MaterialTheme.typography.MainOnBoarding

                )

                Text(

                    text = Strings.MinorThreeOB,
                    style = MaterialTheme.typography.MinorOnBoarding

                )

                var progress by remember { mutableStateOf(0.66f) }

                Box(

                    modifier = Modifier
                        .padding()
                        .padding(bottom = 40.dp)
                        .fillMaxSize(),

                    contentAlignment = Alignment.BottomEnd

                ) {

                    CustomButtonOnBoarding(

                        progress = progress,
                        click = {

                            onNavigateToAuthMain()

                            if (progress < 1) progress += 0.44f

                        }

                    )

                }

            }

        }

    }

}


@Composable
@Preview(showBackground = true)
private fun OnBoardingScreenThreePreview() {

    OnBoardingScreenThree(onNavigateToAuthMain = {})

}