package com.example.svsport.ui.app.CustomUI

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.graphics.Color
import com.example.svsport.ui.theme.Blue
import com.example.svsport.ui.theme.Gray
import com.example.svsport.ui.theme.Gray3
import com.example.svsport.ui.theme.Green

@Composable
fun CustomSwitchNotification(
    isChecked: Boolean,
    onCheckedChange: (Boolean) -> Unit,
    modifier: Modifier = Modifier,
    trackColor: Brush = Brush.linearGradient(listOf(Gray3, Gray3)),
    checkedTrackColor: Brush = Brush.linearGradient(listOf(Blue, Green)),
    thumbColor: Color = Color.White,
    thumbSize: Dp = 14.dp,
    trackHeight: Dp = 24.dp,
    trackWidth: Dp = 44.dp
) {

    val offset by animateDpAsState(targetValue = if (isChecked) trackWidth - thumbSize - 10.dp else 0.dp)

    Box(
        modifier = modifier
            .size(width = trackWidth, height = trackHeight)
            .clip(RoundedCornerShape(50))
            .background(if (isChecked) checkedTrackColor else trackColor)
            .clickable { onCheckedChange(!isChecked) },

        contentAlignment = Alignment.CenterStart

    ) {

        Box(
            modifier = Modifier
                .padding(horizontal = 5.dp)
                .size(thumbSize)
                .offset(x = offset)
                .clip(CircleShape)
                .background(thumbColor)
                .clickable { onCheckedChange(!isChecked) }
        )
    }
}

@Composable
@Preview(showBackground = true)
fun CustomSwitchPreview() {
    var isChecked by remember { mutableStateOf(false) }

    CustomSwitchNotification(
        isChecked = isChecked,
        onCheckedChange = { isChecked = it }
    )

}