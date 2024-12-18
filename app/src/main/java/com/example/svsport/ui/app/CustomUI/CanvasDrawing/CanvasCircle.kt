package com.example.svsport.ui.app.CustomUI.CanvasDrawing

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.translate
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.svsport.ui.theme.WhiteForComponent

@Composable
fun CanvasCircle(
    
    x: Dp,
    y:  Dp,
    radiusCircle: Dp
    
) {

    val density = LocalDensity.current

    Box(modifier = Modifier.wrapContentSize()) {


        Canvas(modifier = Modifier.fillMaxSize()) {

            val offsetX = with(density) { x.toPx() }
            val offsetY = with(density) { y.toPx() }

            translate(left = offsetX, top = offsetY) {

                drawCircle(Color.White.copy(alpha = 0.2f), radius = radiusCircle.toPx())

            }

        }

    }

}

@Composable
@Preview
private fun CanvasCirclePreview() {

    CanvasCircle(x = 30.dp, y = 40.dp, radiusCircle = 100.dp)

}