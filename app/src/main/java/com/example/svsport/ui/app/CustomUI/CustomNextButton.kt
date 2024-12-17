package com.example.svsport.ui.app.CustomUI

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.svsport.ui.theme.ButtonNextText
import com.example.svsport.ui.theme.Pink
import com.example.svsport.ui.theme.PinkButton
import com.example.svsport.ui.theme.Purple
import com.example.svsport.ui.theme.PurpleButton

@Composable
fun CustomNextButton(

    label:String,
    onClick: () -> Unit

) {

    val brush = Brush.horizontalGradient(listOf(PurpleButton, PinkButton))

    Box(

        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(100.dp))
            .background(brush)
            .clickable { onClick() }
            .padding(vertical = 18.dp),

        contentAlignment = Alignment.Center
    ) {

        Text(

            text = label,
            style = MaterialTheme.typography.ButtonNextText

        )

    }

}


@Composable
@Preview
private fun CustomNextButtonPreview() {

    CustomNextButton(label = "Register", onClick = {})

}





