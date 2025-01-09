package com.example.svsport.ui.app.screens.Auth

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.gestures.snapping.SnapPosition
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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.svsport.R
import com.example.svsport.ui.app.CustomUI.CustomAuthInput
import com.example.svsport.ui.app.CustomUI.CustomNextButton
import com.example.svsport.ui.theme.GrayWhite
import com.example.svsport.ui.theme.MainAuth
import com.example.svsport.ui.theme.Meaning
import com.example.svsport.ui.theme.MinorAuth
import com.example.svsport.ui.theme.Pink
import com.example.svsport.ui.theme.PinkButton
import com.example.svsport.ui.theme.PurpleButton
import com.example.svsport.ui.theme.TodayTarget
import com.example.svsport.ui.theme.UnderLineText

@Composable
fun LoginScreen() {

    Surface(

        modifier = Modifier
            .fillMaxSize(),

        color = Color.White

    ) {

        val brush = Brush.linearGradient(listOf(PurpleButton, PinkButton))

        Column(

            modifier = Modifier
                .fillMaxSize(),

            horizontalAlignment = Alignment.CenterHorizontally

        ) {

            Spacer(modifier = Modifier.height(30.dp))

            Column(

                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally

            ) {

                Text(

                    text = "Hey there,",
                    style = MaterialTheme.typography.MinorAuth

                )

                Text(

                    text = "Welcome Back",
                    style = MaterialTheme.typography.MainAuth

                )

            }

            Column(

                modifier = Modifier
                    .padding(horizontal = 30.dp),


                verticalArrangement = Arrangement.spacedBy(15.dp),
                horizontalAlignment = Alignment.CenterHorizontally

            ) {

                CustomAuthInput(

                    image = R.drawable.message,
                    label = "Email",
                    onValueChange = {}

                )

                CustomAuthInput(

                    image = R.drawable.password,
                    label = "Password",
                    onValueChange = {},
                    isPassword = true

                )

                Text(

                    text = "Forgot your password?",
                    style = MaterialTheme.typography.UnderLineText

                )

            }

            Column(

                modifier = Modifier
                    .padding(bottom = 40.dp)
                    .padding(horizontal = 30.dp)
                    .fillMaxHeight(),

                verticalArrangement = Arrangement.Bottom,
                horizontalAlignment = Alignment.CenterHorizontally

            ) {

            CustomNextButton(

                label = "Login",
                onClick = {},
                background = brush

            )

            Row(

                modifier = Modifier
                    .padding(vertical = 30.dp)
                    .fillMaxWidth(),

                horizontalArrangement = Arrangement.spacedBy(10.dp),
                verticalAlignment = Alignment.CenterVertically

            ) {

                Box(

                    modifier = Modifier
                        .weight(1f)
                        .height(1.dp)
                        .background(GrayWhite)

                )

                Text(

                    text = "Or"

                )

                Box(

                    modifier = Modifier
                        .weight(1f)
                        .height(1.dp)
                        .background(GrayWhite)

                )

            }

            Row(

                modifier = Modifier
                    .fillMaxWidth(),

                horizontalArrangement = Arrangement.Center

            ) {

                Box(

                    modifier = Modifier
                        .border(1.dp, GrayWhite, RoundedCornerShape(15.dp))

                ) {

                    Image(

                        modifier = Modifier
                            .padding(15.dp),

                        painter = painterResource(id = R.drawable.google_logo),
                        contentDescription = ""

                    )

                }

                Spacer(modifier = Modifier.width(30.dp))

                Box(

                    modifier = Modifier
                        .border(1.dp, GrayWhite, RoundedCornerShape(15.dp))

                ) {

                    Image(

                        modifier = Modifier
                            .padding(vertical = 20.dp)
                            .padding(horizontal = 24.dp),

                        painter = painterResource(id = R.drawable.facebook_logo),
                        contentDescription = ""

                    )

                }

            }

                Row(

                    modifier = Modifier
                        .padding(top = 30.dp),


                    horizontalArrangement = Arrangement.spacedBy(5.dp)

                ) {

                    Text(

                        text = "Don’t have an account yet?",
                        style = MaterialTheme.typography.TodayTarget

                    )

                    Text(

                        text = "Register",
                        style = MaterialTheme.typography.Meaning

                    )

                }

        }

        }

    }

}

@Composable
@Preview(showBackground = true)
private fun LoginScreenPreview() {

    LoginScreen()

}

