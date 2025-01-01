package com.example.svsport.ui.app.CustomUI

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.svsport.ui.theme.AuthMainText
import com.example.svsport.ui.theme.AuthMinorText
import com.example.svsport.ui.theme.Meaning
import com.example.svsport.ui.theme.MeaningMinor

@Composable
fun CardProfile(

    meaning: String,
    label: String

) {

    Card(

        elevation = CardDefaults.cardElevation(

            defaultElevation = 6.dp

        ),

        colors = CardDefaults.cardColors(

            containerColor = Color.White

        )

    ) {

        Column(

            modifier = Modifier
                .padding(vertical = 10.dp)
                .padding(horizontal = 25.dp),

            verticalArrangement = Arrangement.spacedBy(5.dp)

        ) {

            Text(

                text = meaning,
                style = MaterialTheme.typography.Meaning

            )

            Text(

                text = label,
                style = MaterialTheme.typography.MeaningMinor

            )

        }

    }

}

@Composable
@Preview
private fun CardProfilePreview() {

    CardProfile(meaning = "180cm", label = "Height")

}