package com.example.svsport.ui.app.screens.Main

import android.text.BoringLayout
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.snapping.SnapPosition
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.svsport.R
import com.example.svsport.ui.app.CustomUI.CardProfile
import com.example.svsport.ui.app.CustomUI.CustomAppBar
import com.example.svsport.ui.app.CustomUI.CustomSwitchNotification
import com.example.svsport.ui.app.CustomUI.MainCardProfile
import com.example.svsport.ui.app.data.AccountData
import com.example.svsport.ui.theme.AuthMinorText
import com.example.svsport.ui.theme.MainAppBar
import com.example.svsport.ui.theme.MeaningMinor
import com.example.svsport.ui.theme.MinorComponentAuth
import com.example.svsport.ui.theme.Pink
import com.example.svsport.ui.theme.PinkButton
import com.example.svsport.ui.theme.PurpleButton
import com.example.svsport.ui.theme.TodayTarget

val accountList1 = listOf(

    AccountData(

        img = R.drawable.icon_profile,
        text = "Personal Data",
        endImg = R.drawable.more_profile

    ),

    AccountData(

        img = R.drawable.document_profile,
        text = "Achievement",
        endImg = R.drawable.more_profile

    ),

    AccountData(

        img = R.drawable.graph_profile,
        text = "Activity History",
        endImg = R.drawable.more_profile

    ),

    AccountData(

        img = R.drawable.progress_profile,
        text = "Workout Progress",
        endImg = R.drawable.more_profile

    )


)

val accountList2 = listOf(

    AccountData(

        img = R.drawable.notification_profile,
        text = "Pop-up Notification",
        endImg = R.drawable.more_profile

    )
)

val accountList3 = listOf(

    AccountData(

        img = R.drawable.message_profile,
        text = "Contact Us",
        endImg = R.drawable.more_profile

    ),

    AccountData(

        img = R.drawable.privacy_profile,
        text = "Privacy Policy",
        endImg = R.drawable.more_profile

    ),

    AccountData(

        img = R.drawable.settings_profile,
        text = "Settings",
        endImg = R.drawable.more_profile

    ),

    AccountData(

        img = R.drawable.message_profile,
        text = "Privacy Policy",
        endImg = R.drawable.more_profile

    ),
)



@Composable
fun ProfileScreen(

    weight: String,
    height: String

) {

    val brush = Brush.linearGradient(listOf(PurpleButton, PinkButton))



    Surface(

        modifier = Modifier
            .fillMaxSize(),

        color = Color.White

    ) {


        Column(

            modifier = Modifier
                .fillMaxSize()

        ) {

            Spacer(modifier = Modifier.height(40.dp))

            CustomAppBar(label = "Profile")

            Spacer(modifier = Modifier.height(35.dp))

            Column(



            ) {

                Row(

                    modifier = Modifier
                        .padding(horizontal = 30.dp)
                        .fillMaxWidth(),

                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween

                ) {

                    Box(

                        modifier = Modifier
                            .clip(CircleShape)
                            .background(Pink.copy(alpha = 0.8f))


                    ) {

                        Image(

                            painter = painterResource(id = R.drawable.profile_photo),
                            contentDescription = ""

                        )

                    }

                    Column(

                        modifier = Modifier
                            .padding(end = 80.dp),

                        verticalArrangement = Arrangement.spacedBy(5.dp)

                    ) {

                        Text(

                            text = "Andrey Sviridovsky",
                            style = MaterialTheme.typography.TodayTarget

                        )

                        Text(

                            text = "Lose a Fat Program",
                            style = MaterialTheme.typography.AuthMinorText


                        )

                    }


                    Box(

                        modifier = Modifier
                            .clip(RoundedCornerShape(50.dp))
                            .background(brush)


                    ) {

                        Text(

                            modifier = Modifier
                                .padding(horizontal = 15.dp)
                                .padding(vertical = 5.dp),

                            text = "Edit",
                            style = MaterialTheme.typography.MinorComponentAuth

                        )

                    }


                }

            }

            Spacer(modifier = Modifier.height(23.dp))

            Row(

                modifier = Modifier
                    .padding(horizontal = 30.dp)
                    .fillMaxWidth(),

                horizontalArrangement = Arrangement.SpaceBetween

            ) {

                CardProfile(meaning = "$height cm", label = "Height")

                CardProfile(meaning = "$weight kg", label = "Weight")

                CardProfile(meaning = "22yo", label = "Age")

            }
            
            Spacer(modifier = Modifier.height(30.dp))
            
            Column(

                verticalArrangement = Arrangement.spacedBy(15.dp)

            ) {

                MainCardProfile(

                    title = "Account",
                    list = accountList1

                )

                MainCardProfile(

                    title = "Notification",
                    list = accountList2

                )

                MainCardProfile(

                    title = "Other",
                    list = accountList3

                )

            }

        }

    }

}

/*@Composable
private fun My6Card(
    modifier: Modifier = Modifier,
    title: String,
    content: @Composable ColumnScope.() -> Unit
) {

    Card(
        modifier = modifier
    ) {
        Column {
            content()
        }

    }

}*/

@Composable
fun AccountDesign(

    index: AccountData,
    isSwitch: Boolean = false

) {

    val checkedState = remember { mutableStateOf(true)}

    Row(

        modifier = Modifier
            .fillMaxWidth(),

        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically

    ) {

        Row {

            Image(

                painter = painterResource(id = index.img),
                contentDescription = ""

            )

            Spacer(modifier = Modifier.width(10.dp))

            Text(

                text = index.text,
                style = MaterialTheme.typography.MeaningMinor

            )

        }
        
        if (isSwitch) {
            
            CustomSwitchNotification(

                isChecked = checkedState.value,
                onCheckedChange = { newState ->

                    checkedState.value = newState

                }

            )

            
        } else {

            Image(

                painter = painterResource(index.endImg),
                contentDescription = ""

            )

        }

    }

}

@Composable
@Preview(showBackground = true)
private fun ProfileScreenPreview() {

    ProfileScreen("80", "180")

}