package com.example.svsport.ui.app.CustomUI

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun CustomTrackerDiagram() {

    Card(

        modifier = Modifier
            .fillMaxWidth(),

        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)

    ) {

        LazyRow {

        }

    }

}



@Composable
@Preview(showBackground = true)
private fun CustomTrackerDiagramPreview() {

    CustomTrackerDiagram()

}