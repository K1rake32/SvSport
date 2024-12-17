package com.example.svsport.ui.app.CustomUI

import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.LinearGradient
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.svsport.R
import com.example.svsport.ui.theme.Pink
import com.example.svsport.ui.theme.PinkButton
import com.example.svsport.ui.theme.Purple
import com.example.svsport.ui.theme.PurpleButton

@Composable
fun CustomButtonOnBoarding(

    progress: Float,
    click: () -> Unit,


    ) {

    val animatedProgress  = animateFloatAsState(

        targetValue = progress,
        animationSpec = tween(durationMillis = 800, easing = FastOutSlowInEasing)

    ).value


    val brush = Brush.linearGradient(listOf(PurpleButton, PinkButton))

    Box(

        modifier = Modifier.size(65.dp),

        contentAlignment = Alignment.Center


        ) {

        Canvas(modifier = Modifier.size(100.dp)) {

            drawArc(

                brush,
                startAngle = -90f,
                sweepAngle = 360f * animatedProgress,
                useCenter = false,
                style = Stroke(width = 2.dp.toPx(), cap = StrokeCap.Round)


            )

        }

        Box(

            modifier = Modifier
                .clip(CircleShape)
                .background(brush)
                .clickable { click() }


        ) {

            Image(

                modifier = Modifier
                    .padding(horizontal = 22.dp)
                    .padding(vertical = 20.dp),

                painter = painterResource(id = R.drawable.next_button),
                contentDescription = ""

            )

        }


    }

}

@Composable
@Preview
private fun CustomButtonOnBoardingPreview(){

    CustomButtonOnBoarding(click = {}, progress = 0.3f)

}