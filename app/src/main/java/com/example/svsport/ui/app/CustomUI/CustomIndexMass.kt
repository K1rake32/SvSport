package com.example.svsport.ui.app.CustomUI

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.svsport.ui.app.CustomUI.CanvasDrawing.CanvasCircle
import com.example.svsport.ui.theme.ButtonMainScreen
import com.example.svsport.ui.theme.CustomComponentAuth
import com.example.svsport.ui.theme.MinorComponentAuth
import com.example.svsport.ui.theme.Pink
import com.example.svsport.ui.theme.PinkButton
import com.example.svsport.ui.theme.Purple
import com.example.svsport.ui.theme.PurpleButton

@Composable
fun CustomIndexMass(

    value: Float,
    total: Float = 360f,

) {

    val brush = Brush.linearGradient(listOf(Pink, Purple))

    Box(

        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(22.dp))
            .background(brush)

    ) {

        Column(

            modifier = Modifier
                .padding(horizontal = 20.dp)
                .padding(vertical = 26.dp)

        ) {

            Row (

                modifier = Modifier.fillMaxWidth(),

                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.Top


            ){

                Column(

                    verticalArrangement = Arrangement.spacedBy(5.dp)

                ) {

                    val brushForButton = Brush.linearGradient(listOf(PurpleButton, PinkButton))

                    Text(

                        text = "BMI (Body Mass Index)",
                        style = MaterialTheme.typography.CustomComponentAuth

                    )
                    
                    Text(

                        text = "You have a normal weight",
                        style = MaterialTheme.typography.MinorComponentAuth

                    )
                    
                    Spacer(modifier = Modifier.height(15.dp))

                    Box(

                        modifier = Modifier
                            .clip(RoundedCornerShape(50.dp))
                            .background(brushForButton)

                    ) {

                        Text(

                            modifier = Modifier
                                .padding(horizontal = 21.dp)
                                .padding(vertical = 10.dp),

                            text = "View More",
                            style = MaterialTheme.typography.ButtonMainScreen

                        )

                    }

                }

                Canvas(modifier = Modifier.size(80.dp)) {
                    drawCircle(
                        color = Color.White.copy(alpha = 0.9f),
                        radius = size.minDimension / 2
                    )

                    val radius = size.minDimension / 2
                    val arcPadding = 20.dp.toPx()
                    val arcSize = Size(

                        width = (radius * 2) + arcPadding,
                        height = (radius * 2) + arcPadding

                    )

                    drawArc(
                        brush = brush,
                        startAngle = -90f,
                        sweepAngle = (value / total) * 360f,
                        useCenter = true,
                        size = arcSize,
                        topLeft = Offset(

                            x = -arcPadding / 2,
                            y = - arcPadding / 2

                        )
                    )

                }

            }

            Spacer(modifier = Modifier.height(0.dp))

            Box(
                modifier = Modifier

                    .fillMaxWidth()
                    .height(0.dp),

                contentAlignment = Alignment.BottomEnd
            ) {

                CanvasCircle(x = 150.dp, y = 10.dp, radiusCircle = 35.dp)

                CanvasCircle(x = -150.dp, y = 25.dp, radiusCircle = 25.dp)

                CanvasCircle(x = -30.dp, y = -10.dp, radiusCircle = 5.dp)

                CanvasCircle(x = 20.dp, y = 10.dp, radiusCircle = 5.dp)

                CanvasCircle(x = 4.dp, y = -92.dp, radiusCircle = 5.dp)

                CanvasCircle(x = -55.dp, y = -100.dp, radiusCircle = 5.dp)

            }

        }

    }

}

@Composable
@Preview
private fun CustomIndexMassPreview() {

    CustomIndexMass(120f,)

}