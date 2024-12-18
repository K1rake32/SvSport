package com.example.svsport.ui.app.CustomUI

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.svsport.ui.theme.CustomComponentAuth
import com.example.svsport.ui.theme.Pink
import com.example.svsport.ui.theme.Purple

@Composable
fun CustomComponentAuth(

    text: String

) {

    val brush = Brush.linearGradient(listOf(Pink, Purple))

    Box(

        modifier = Modifier
            .clip(RoundedCornerShape(15.dp))
            .background(brush),


    ) {

        Text(

            modifier = Modifier
                .padding(20.dp),

            text = text,
            style = MaterialTheme.typography.CustomComponentAuth

        )

    }

}

@Composable
@Preview(showBackground = true)
private fun CustomComponentAuthPreview() {

    CustomComponentAuth(text = "KG")

}