package com.example.svsport.ui.app.screens.Auth



import android.widget.Space
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.svsport.R
import com.example.svsport.ui.app.CustomUI.CustomAuthCheckbox
import com.example.svsport.ui.app.CustomUI.CustomAuthInput
import com.example.svsport.ui.app.CustomUI.CustomButtonOnBoarding
import com.example.svsport.ui.app.CustomUI.CustomNextButton
import com.example.svsport.ui.theme.GrayWhite
import com.example.svsport.ui.theme.MainAuth
import com.example.svsport.ui.theme.MinorAuth
import com.example.svsport.ui.theme.Strings
import com.example.svsport.ui.theme.TeamConditionText

@Composable
fun AuthMainScreen(

    onNavigateToFillOut: () -> Unit

) {

    val checkedState = remember { mutableStateOf(false)}

    Surface(

        modifier = Modifier
            .padding(top = 32.dp)
            .fillMaxSize(),

        color = Color.White

    ) {

        Column(

            modifier = Modifier
                .padding(horizontal = 30.dp)
                .fillMaxSize(),

            horizontalAlignment = Alignment.CenterHorizontally

        ) {

            Text(

                text = "Hey there,",
                style = MaterialTheme.typography.MinorAuth

            )

            Spacer(modifier = Modifier.height(5.dp))

            Text(

                text = "Create an Account",
                style = MaterialTheme.typography.MainAuth

            )

            Spacer(modifier = Modifier.height(30.dp))

            Column(

                modifier = Modifier
                    .padding(0.dp),

                verticalArrangement = Arrangement.spacedBy(15.dp),
                horizontalAlignment = Alignment.Start

            ) {

                CustomAuthInput(

                    image = R.drawable.profile,
                    label = "Full Name",
                    onValueChange = {}

                )

                CustomAuthInput(

                    image = R.drawable.phone,
                    label = "Phone Number",
                    onValueChange = {},
                    isNumber = true

                )

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

                Row(
                    modifier = Modifier
                        .fillMaxWidth(),


                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Start,

                ){

                    CustomAuthCheckbox(

                        isChecked = checkedState.value,
                        onCheckedChange = { newState ->

                            checkedState.value = newState

                        }

                    )

                    Text(

                        text = Strings.TeamCondition,
                        style = MaterialTheme.typography.TeamConditionText

                    )

                }

            }

            Spacer(modifier = Modifier.height(110.dp))

            Column (

                modifier = Modifier
                    .fillMaxSize(),

                horizontalAlignment = Alignment.CenterHorizontally

            ) {

                CustomNextButton(label = "Register", onClick = {onNavigateToFillOut()})

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
                        .padding(top = 30.dp)

                ) {

                    Text(

                        text = "Already have an account? Login"

                    )

                }

            }

        }

    }

}

@Composable
@Preview(showBackground = true)
private fun AuthMainScreenPreview() {

    AuthMainScreen(onNavigateToFillOut = {})

}