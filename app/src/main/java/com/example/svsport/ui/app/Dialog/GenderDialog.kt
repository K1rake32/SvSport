package com.example.svsport.ui.app.Dialog

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.example.svsport.R
import com.example.svsport.ui.theme.DialogFemale
import com.example.svsport.ui.theme.DialogMale
import com.example.svsport.ui.theme.Gray3

@Composable
fun GenderDialog(openDialog: MutableState<Boolean>, onGenderSelected: (String) -> Unit) {

    val showImage = remember { mutableStateOf<String?>(null) }

    Dialog(onDismissRequest = { openDialog.value = false }) {

        Card(

            shape = RoundedCornerShape(10.dp),

            elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),

            colors = CardDefaults.cardColors(containerColor = Color.White)

        ) {

            Column(

                modifier = Modifier
                    .padding(10.dp),

                ) {

                Row(

                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable {

                            showImage.value = "Male"
                            onGenderSelected("Male")
                            openDialog.value = false

                                   },

                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically

                ) {

                    Text(

                        modifier = Modifier
                            .padding(vertical = 5.dp),

                        text = "Male",
                        style = MaterialTheme.typography.DialogMale

                    )

                    if (showImage.value == "Male") {

                        Image(

                            painter = painterResource(id = R.drawable.privacy_profile),
                            contentDescription = ""

                        )

                    }

                }


                Box(

                    modifier = Modifier
                        .fillMaxWidth()
                        .height(2.dp)
                        .background(Color.Black)

                )

                Row(

                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable {

                            showImage.value = "Female"
                            onGenderSelected("Female")
                            openDialog.value = false

                                   },

                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically

                ) {

                    Text(

                        modifier = Modifier
                            .padding(vertical = 5.dp),

                        text = "Female",
                        style = MaterialTheme.typography.DialogFemale

                    )

                    if (showImage.value == "Female") {
                        Image(

                            painter = painterResource(id = R.drawable.privacy_profile),
                            contentDescription = "Female Icon"

                        )

                    }

                }

            }

        }

    }
}

@Composable
@Preview
private fun GenderDialogPreview() {

    GenderDialog(openDialog = remember { mutableStateOf(true)}, {})

}