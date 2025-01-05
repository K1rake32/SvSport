package com.example.svsport.ui.app.CustomUI.CanvasDrawing

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.translate
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.svsport.ui.theme.Blue
import com.example.svsport.ui.theme.Gray
import com.example.svsport.ui.theme.Green

@Composable
fun CanvasRectangle(
    color: Brush,
    value: Float
) {
    Canvas(
        modifier = Modifier
            .width(22.dp)
            .height(135.dp)
    ) {
        val canvasWidth = size.width
        val canvasHeight = size.height

        val filledHeight = canvasHeight * value

        translate {

            drawRoundRect(
                color = Gray,
                topLeft = Offset(0f, 0f),
                size = Size(canvasWidth, canvasHeight),
                cornerRadius = CornerRadius(canvasWidth / 2, canvasWidth / 2)
            )


            drawRoundRect(
                brush = color,
                topLeft = Offset(0f, canvasHeight - filledHeight),
                size = Size(canvasWidth, filledHeight),
                cornerRadius = CornerRadius(canvasWidth / 2, canvasWidth / 2)
            )
        }
    }
}

@Composable
@Preview
private fun CanvasRectanglePreview() {

    val brush = Brush.linearGradient(listOf(Blue, Green))

    CanvasRectangle(color = brush, value = 0.4f)

}