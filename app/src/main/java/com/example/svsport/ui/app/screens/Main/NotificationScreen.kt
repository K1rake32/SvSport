package com.example.svsport.ui.app.screens.Main

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.svsport.ui.app.CustomUI.CustomAppBar
import com.example.svsport.ui.app.data.NotificationData

@Composable
fun NotificationScreen() {

    Surface(

        modifier = Modifier
            .fillMaxSize()

    ) {

        Column(

            modifier = Modifier
                .fillMaxSize()

        ) {

            CustomAppBar(label = "Notification")

            LazyColumn(

                modifier = Modifier
                    .fillMaxSize()

            ) {



            }

        }

    }

}


@Composable
@Preview(showBackground = true)
private fun NotificationScreenPreview() {

    NotificationScreen()

}