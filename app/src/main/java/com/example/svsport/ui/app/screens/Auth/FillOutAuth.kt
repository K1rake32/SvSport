package com.example.svsport.ui.app.screens.Auth

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.drawscope.translate
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.svsport.R
import com.example.svsport.ui.app.CustomUI.CustomAuthInput
import com.example.svsport.ui.app.CustomUI.CustomNextButton
import com.example.svsport.ui.theme.AuthMainText
import com.example.svsport.ui.theme.AuthMinorText
import com.example.svsport.ui.theme.Pink
import com.example.svsport.ui.theme.Purple

@Composable
fun FillOutAuth(



) {

    Surface(

        modifier = Modifier
            .fillMaxSize()

    ) {

        Column(

            modifier = Modifier
                .fillMaxSize()

        ) {

            Box(

                modifier = Modifier
                    .fillMaxWidth(),

                contentAlignment = Alignment.TopCenter

            ) {

                val brush = Brush.linearGradient(listOf(Purple, Pink))

                Canvas(modifier = Modifier.matchParentSize()) {

                        translate(left = 0f, top = 70f) {

                            drawCircle(brush, radius = 150.dp.toPx())

                    }

                }

                Image(

                    modifier = Modifier
                        .padding(top = 62.dp),

                    painter = painterResource(id = R.drawable.onboardng_tree),
                    contentDescription = ""

                )

            }

            Spacer(modifier = Modifier.height(50.dp))

            Column(

                modifier = Modifier
                    .fillMaxWidth(),

                verticalArrangement = Arrangement.spacedBy(5.dp),
                horizontalAlignment = Alignment.CenterHorizontally

            ) {

                Text(

                    text = "Let’s complete your profile",
                    style = MaterialTheme.typography.AuthMainText

                )

                Text(

                    text = "It will help us to know more about you!",
                    style = MaterialTheme.typography.AuthMinorText

                )

            }

            Spacer(modifier = Modifier.height(30.dp))

            Column(

                modifier = Modifier
                    .padding(horizontal = 40.dp)
                    .fillMaxWidth(),

                verticalArrangement = Arrangement.spacedBy(15.dp),
                horizontalAlignment = Alignment.CenterHorizontally

            ) {

                CustomAuthInput(

                    image = R.drawable.gender,
                    label = "Choose Gender",
                    onValueChange = { /*TODO*/ }

                )

                CustomAuthInput(

                    image = R.drawable.calendar,
                    label = "Date of Birth",
                    onValueChange = { /*TODO*/ }

                )

                CustomAuthInput(

                    image = R.drawable.weigth,
                    label = "Your Weight",
                    onValueChange = { /*TODO*/ }

                )

                CustomAuthInput(

                    image = R.drawable.height,
                    label = "Your Height",
                    onValueChange = { /*TODO*/ }

                )

            }

            Spacer(modifier = Modifier.height(30.dp))


            Box(modifier = Modifier.padding(horizontal = 40.dp)) {

                CustomNextButton(label = "Next", onClick = {})

            }

        }

    }

}

@Composable
@Preview(showBackground = true)
private fun FillOutAuthPreview() {

    FillOutAuth()

}