package com.example.svsport.ui.app.screens.Main

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.svsport.R
import com.example.svsport.ui.app.CustomUI.CustomAppBar
import com.example.svsport.ui.app.data.NotificationData
import com.example.svsport.ui.theme.Blue
import com.example.svsport.ui.theme.Gray
import com.example.svsport.ui.theme.Gray3
import com.example.svsport.ui.theme.Green
import com.example.svsport.ui.theme.MainNotification
import com.example.svsport.ui.theme.TeamConditionText


val notificationList = listOf(

    NotificationData(

        startImg = R.drawable.lunch,
        mainLabel = "Hey, it’s time for lunch",
        minorLabel = "About 1 minutes ago",
        endImg = R.drawable.more

    ),

    NotificationData(

        startImg = R.drawable.lunch,
        mainLabel = "Hey, it’s time for lunch",
        minorLabel = "About 1 minutes ago",
        endImg = R.drawable.more

    ),

    NotificationData(

        startImg = R.drawable.lunch,
        mainLabel = "Hey, it’s time for lunch",
        minorLabel = "About 1 minutes ago",
        endImg = R.drawable.more

    ),

    NotificationData(

        startImg = R.drawable.lunch,
        mainLabel = "Hey, it’s time for lunch",
        minorLabel = "About 1 minutes ago",
        endImg = R.drawable.more

    ),

    NotificationData(

        startImg = R.drawable.lunch,
        mainLabel = "Hey, it’s time for lunch",
        minorLabel = "About 1 minutes ago",
        endImg = R.drawable.more

    ),

    )
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

            Spacer(modifier = Modifier.height(10.dp))

            CustomAppBar(label = "Notification")

            Spacer(modifier = Modifier.height(30.dp))

            LazyColumn(

                modifier = Modifier
                    .fillMaxSize(),

                verticalArrangement = Arrangement.spacedBy(15.dp)

            ) {

                items(notificationList.size) {

                    NotificationDesign(index = it)

                }

            }

        }

    }

}


@Composable
fun NotificationDesign(

    index: Int

) {

    val item = notificationList[index]
    val brush = Brush.linearGradient(listOf(Green, Blue))

    Column(

        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White)

    ) {

        Row(

            modifier = Modifier
                .padding(horizontal = 30.dp)
                .fillMaxWidth(),

            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween

        ) {

            Row(

                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(10.dp)

            ) {

                Box(

                    modifier = Modifier
                        .clip(CircleShape)
                        .background(brush)

                ) {

                    Image(

                        modifier = Modifier
                            .padding(vertical = 12.dp)
                            .padding(horizontal = 7.dp),

                        painter = painterResource(id = item.startImg),
                        contentDescription = ""

                    )

                }

                Column(

                    modifier = Modifier
                    ,

                    verticalArrangement = Arrangement.spacedBy(5.dp)

                ) {

                    Text(

                        text = item.mainLabel,
                        style = MaterialTheme.typography.MainNotification

                    )

                    Text(

                        text = item.minorLabel,
                        style = MaterialTheme.typography.TeamConditionText

                    )

                }
            }

            Image(

                painter = painterResource(id = item.endImg),
                contentDescription = ""

            )

        }

        Spacer(modifier = Modifier.height(15.dp))

        Box(

            modifier = Modifier
                .padding(horizontal = 30.dp)
                .fillMaxWidth()
                .height(1.dp)
                .background(Gray3)

        )

    }

}


@Composable
@Preview(showBackground = true)
private fun NotificationScreenPreview() {

    NotificationScreen()

}

@Composable
@Preview
fun NotificationDesignPreview() {

    NotificationDesign(index = 1)

}