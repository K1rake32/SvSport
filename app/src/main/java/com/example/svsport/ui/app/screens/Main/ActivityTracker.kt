package com.example.svsport.ui.app.screens.Main

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.svsport.R
import com.example.svsport.ui.app.CustomUI.CanvasDrawing.CanvasRectangle
import com.example.svsport.ui.app.CustomUI.CustomAppBar
import com.example.svsport.ui.app.CustomUI.CustomTarget
import com.example.svsport.ui.app.data.ProgressData
import com.example.svsport.ui.theme.Blue
import com.example.svsport.ui.theme.ButtonMainScreen
import com.example.svsport.ui.theme.CustomComponentAuth
import com.example.svsport.ui.theme.Green
import com.example.svsport.ui.theme.InputAuthText
import com.example.svsport.ui.theme.MainAppBar
import com.example.svsport.ui.theme.Pink
import com.example.svsport.ui.theme.PinkButton
import com.example.svsport.ui.theme.Purple
import com.example.svsport.ui.theme.PurpleButton
import com.example.svsport.ui.theme.TargetMain
import com.example.svsport.ui.theme.TodayTarget

private val brushGreen = Brush.horizontalGradient(listOf(Blue, Green))
private val brushPurple = Brush.horizontalGradient(listOf(Pink, Purple))

val trackerList = listOf(

    ProgressData(

        canvasContent = { CanvasRectangle(color = brushGreen, value = 0.3f) },
        text = "Sun"

    ),

    ProgressData(

        canvasContent = { CanvasRectangle(color = brushPurple, value = 0.7f) },
        text = "Mon"

    ),

    ProgressData(

        canvasContent = { CanvasRectangle(color = brushGreen, value = 0.5f) },
        text = "Tue"

    ),

    ProgressData(

        canvasContent = { CanvasRectangle(color = brushPurple, value = 0.6f) },
        text = "Wed"

    ),

    ProgressData(

        canvasContent = { CanvasRectangle(color = brushGreen, value = 0.8f) },
        text = "Thu"

    ),

    ProgressData(

        canvasContent = { CanvasRectangle(color = brushPurple, value = 0.3f) },
        text = "Fri"

    ),

    ProgressData(

        canvasContent = { CanvasRectangle(color = brushGreen, value = 0.55f) },
        text = "Sat"

    ),

)
@Composable
fun ActivityTracker() {

    Surface(

        modifier = Modifier
            .fillMaxSize(),

        color = Color.White

    ) {

        Column(

            modifier = Modifier
                .fillMaxSize()

        ) {

            CustomAppBar(label = "Activity Tracker", {})
            
            Spacer(modifier = Modifier.height(30.dp))

            Box(

                modifier = Modifier
                    .padding(horizontal = 30.dp)
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(22.dp))
                    .background(Pink.copy(alpha = 0.3f))

            ) {

                Column(

                    modifier = Modifier
                        .padding(20.dp)

                ) {

                    val brush = Brush.linearGradient(listOf(PurpleButton, PinkButton))

                    Row (

                        modifier = Modifier
                            .fillMaxWidth(),

                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically

                    ) {

                        Text(

                            text = "Today Target",
                            style = MaterialTheme.typography.TargetMain

                        )

                        Box(

                            modifier = Modifier
                                .clip(RoundedCornerShape(8.dp))
                                .background(brush)

                        ) {

                            Image(

                                modifier = Modifier
                                    .padding(5.dp),

                                painter = painterResource(id = R.drawable.plus),
                                contentDescription = ""

                            )

                        }

                    }

                    Spacer(modifier = Modifier.height(15.dp))

                    Row(

                        modifier = Modifier
                            .fillMaxWidth(),

                        horizontalArrangement = Arrangement.SpaceBetween

                    ) {

                        CustomTarget(

                            R.drawable.glass,
                            "8L",
                            "Water Intake"

                        )

                        CustomTarget(

                            R.drawable.boots,
                            "2400",
                            "Foot Steps"

                        )

                    }

                }

            }

            Spacer(modifier = Modifier.height(30.dp))

            Row(

                modifier = Modifier
                    .padding(horizontal = 30.dp)
                    .fillMaxWidth(),

                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically

            ) {

                val brush = Brush.linearGradient(listOf(Blue, Green))

                Text(

                    text = "Activity Progress",
                    style = MaterialTheme.typography.MainAppBar

                )

                Box(

                    modifier = Modifier
                        .clip(CircleShape)
                        .background(brush)

                ) {

                    Row(

                        modifier = Modifier
                            .padding(8.dp),

                        horizontalArrangement = Arrangement.spacedBy(5.dp),
                        verticalAlignment = Alignment.CenterVertically


                    ) {

                        Text(

                            text = "Weekly",
                            style = MaterialTheme.typography.ButtonMainScreen

                        )

                        Image(

                            painter = painterResource(id = R.drawable.choose),
                            contentDescription = "",

                            colorFilter = ColorFilter.tint(Color.White)

                        )
                    }
                    
                    Spacer(modifier = Modifier.height(15.dp))

                }

            }

            Spacer(modifier = Modifier.height(15.dp))

            Card(

                modifier = Modifier
                    .padding(horizontal = 30.dp)
                    .fillMaxWidth()
                    .height(200.dp),

                colors = CardDefaults.cardColors(containerColor = Color.White),

                elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)

            ) {

                LazyRow(

                    modifier = Modifier
                        .padding(20.dp)
                        .fillMaxWidth(),

                    horizontalArrangement = Arrangement.SpaceBetween

                ) {

                    items(trackerList.size) {

                        TrackerDesign(index = it)

                    }

                }

            }

        }

    }

}


@Composable
fun TrackerDesign(

    index: Int

) {

    val items = trackerList[index]

    Column (

    ) {

        items.canvasContent()

        Spacer(modifier = Modifier.height(10.dp))

        Text(

            text = items.text,
            style = MaterialTheme.typography.InputAuthText

        )

    }

}

@Composable
@Preview(showBackground = true)
private fun ActivityTrackerPreview() {

    ActivityTracker()

}