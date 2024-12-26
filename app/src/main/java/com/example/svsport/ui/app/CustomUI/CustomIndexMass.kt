package com.example.svsport.ui.app.CustomUI

import android.graphics.Typeface
import android.util.Log
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
import androidx.compose.ui.graphics.nativeCanvas
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.res.ResourcesCompat
import com.example.svsport.R
import com.example.svsport.ui.app.CustomUI.CanvasDrawing.CanvasCircle
import com.example.svsport.ui.theme.ButtonMainScreen
import com.example.svsport.ui.theme.CustomComponentAuth
import com.example.svsport.ui.theme.MinorComponentAuth
import com.example.svsport.ui.theme.Pink
import com.example.svsport.ui.theme.PinkButton
import com.example.svsport.ui.theme.Purple
import com.example.svsport.ui.theme.PurpleButton
import com.example.svsport.ui.theme.WhiteForComponent
import kotlin.math.cos
import kotlin.math.sin

@Composable
fun CustomIndexMass(

    value: Float,
    total: Float = 360f,
    label: String,
    iMT: String

) {

    val context = LocalContext.current
    val density = LocalDensity.current

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

                        text = label,
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

                    val iMTFloat = iMT.toFloatOrNull() ?: 0f

                    val progressAngl = if (iMTFloat != null) {
                        when {
                            iMTFloat < 10f -> 0f
                            iMTFloat > 40f -> 360f
                            else -> ((iMTFloat - 10f) / 30f) * 360f
                        }
                    } else {
                        0f
                    }
                        drawArc(
                            brush = brush,
                            startAngle = -90f,
                            sweepAngle = progressAngl,
                            useCenter = true,
                            size = arcSize,
                            topLeft = Offset(
                                x = -arcPadding / 2,
                                y = -arcPadding / 2
                            )
                        )

                    val typeface = Typeface.create(
                        ResourcesCompat.getFont(context, R.font.poppins_bold),
                        Typeface.NORMAL
                    )

                    val textPaint = android.graphics.Paint().apply {
                        color = Color.Black.toArgb()
                        textSize = with(density) {12.sp.toPx()}
                        this.typeface = typeface
                        isAntiAlias = true
                    }

                    val progressAngle = when {
                        iMTFloat < 10f -> 0f
                        iMTFloat > 40f -> 360f
                        else -> ((iMTFloat - 10f) / 30f) * 360f
                    }

                    val middleAngle = Math.toRadians((progressAngle / 2 - 80).toDouble())
                    val textRadius = radius * 0.8f

                    val dynamicX = (size.width / 3 + textRadius * cos(middleAngle)).toFloat()
                    val dynamicY = (size.height / 2 + textRadius * sin(middleAngle)).toFloat()

                    drawContext.canvas.nativeCanvas.drawText(
                        iMT,
                        dynamicX,
                        dynamicY,
                        textPaint

                    )

                }


            }

        }

        Spacer(modifier = Modifier.height(0.dp))

        Box(
            modifier = Modifier

                .fillMaxWidth()
                .height(0.dp),

            contentAlignment = Alignment.BottomEnd
        ) {

            CanvasCircle(x = 160.dp, y = 150.dp, radiusCircle = 35.dp)

            CanvasCircle(x = -165.dp, y = 150.dp, radiusCircle = 25.dp)

            CanvasCircle(x = 3.dp, y = 25.dp, radiusCircle = 5.dp)

            CanvasCircle(x = 30.dp, y = 135.dp, radiusCircle = 5.dp)

            CanvasCircle(x = -55.dp, y = 15.dp, radiusCircle = 5.dp)

            CanvasCircle(x = -30.dp, y = 115.dp, radiusCircle = 5.dp)

        }

    }

}


@Composable
@Preview
private fun CustomIndexMassPreview() {

    CustomIndexMass(360f, label = "You have a normal weight", iMT = "30")

}