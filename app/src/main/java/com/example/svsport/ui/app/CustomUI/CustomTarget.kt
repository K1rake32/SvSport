package com.example.svsport.ui.app.CustomUI

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.svsport.R
import com.example.svsport.ui.theme.AuthMinorText
import com.example.svsport.ui.theme.Meaning

@Composable
fun CustomTarget(

    image: Int,
    meaning: String,
    label: String

) {

    Box(

        modifier = Modifier
            .width(130.dp)
            .clip(RoundedCornerShape(12.dp))
            .background(Color.White)

    ) {

        Row(

            modifier = Modifier
                .padding(10.dp),

            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalAlignment = Alignment.CenterVertically

        ) {

            Image(

                painter = painterResource(id = image),
                contentDescription = ""

            )

            Column {

                Text(

                    text = meaning,
                    style = MaterialTheme.typography.Meaning

                )

                Text(

                    text = label,
                    style = MaterialTheme.typography.AuthMinorText

                )

            }

        }

    }

}

@Composable
@Preview
private fun CustomTargetPreview() {

    CustomTarget(R.drawable.glass, "8L", "Water Intake")

}