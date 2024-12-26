package com.example.svsport.ui.app.CustomUI

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.svsport.R
import com.example.svsport.ui.theme.Gray
import com.example.svsport.ui.theme.MainAppBar


@Composable
fun CustomAppBar(

    label: String

) {

    Row(

        modifier = Modifier
            .padding(horizontal = 30.dp)
            .fillMaxWidth()
            .background(Color.White),

        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically

    ) {

        Box(

            modifier = Modifier
                .clip(RoundedCornerShape(8.dp))
                .background(Gray)

        ) {
            
            Image(

                modifier = Modifier
                    .padding(horizontal = 13.dp)
                    .padding(vertical = 11.dp),

                painter = painterResource(id = R.drawable.back_icon),
                contentDescription = ""

            )
            
        }

        Text(

            text = label,
            style = MaterialTheme.typography.MainAppBar

        )

        Box(

            modifier = Modifier
                .clip(RoundedCornerShape(8.dp))
                .background(Gray)

        ) {

            Image(

                modifier = Modifier
                    .padding(horizontal = 11.dp)
                    .padding(vertical = 14.dp),

                painter = painterResource(id = R.drawable.dots),
                contentDescription = ""

            )

        }


    }

}

@Composable
@Preview
private fun CustomAppBarPreview() {

    CustomAppBar(label = "Notification")

}