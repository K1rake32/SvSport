package com.example.svsport.ui.app.CustomUI

import android.icu.text.ListFormatter.Width
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.max
import com.example.svsport.R
import com.example.svsport.ui.app.screens.Auth.PhoneMask.PhoneMaskTransformation
import com.example.svsport.ui.theme.Gray
import com.example.svsport.ui.theme.GrayTextAuth
import com.example.svsport.ui.theme.InputAuthText

@Composable
fun CustomAuthInput(

    image: Int,
    label: String,
    onValueChange: (String) -> Unit,
    isNumber: Boolean = false,
    isPassword: Boolean = false,
    isMaxWidth: Boolean = true,
    width: Dp = Dp.Unspecified,
    isInt: Boolean = false

) {

    var textFieldValue by remember { mutableStateOf("") }
    var passwordVisible by remember { mutableStateOf(false) }

    TextField(

        modifier = Modifier
            .then(if(isMaxWidth) Modifier.fillMaxWidth() else Modifier.width(width)),

        shape = RoundedCornerShape(14.dp),

        value = textFieldValue,
        onValueChange = { newText ->

            val filterText = if (isNumber) {

                val digits = newText.filter { it.isDigit() }

                if (digits.length <= 10) digits else textFieldValue

            } else {

                newText

            }

            if (filterText != textFieldValue) {
                textFieldValue = filterText
                onValueChange(filterText)
            }
        },

        colors = TextFieldDefaults.colors(

            focusedContainerColor = Gray,
            unfocusedContainerColor = Gray,
            unfocusedIndicatorColor = Color.Transparent,
            focusedIndicatorColor = Color.Transparent,
            focusedTextColor = GrayTextAuth,
            unfocusedTextColor = GrayTextAuth

        ),

        placeholder = {

            Text(

                text = label,
                style = MaterialTheme.typography.InputAuthText

            )

        },

        leadingIcon = {

            Image(

                painter = painterResource(image),
                contentDescription = ""

            )

        },

        keyboardOptions = KeyboardOptions.Default.copy(

            keyboardType = if (isNumber || isInt) KeyboardType.Number else KeyboardType.Text

        ),

        visualTransformation = when {
            isPassword && !passwordVisible -> PasswordVisualTransformation()
            isNumber -> PhoneMaskTransformation()
            else -> VisualTransformation.None
        },
        
        trailingIcon = {
            
            if (isPassword) {

                IconButton(onClick = { passwordVisible = !passwordVisible }) {

                    val icon = if(passwordVisible) R.drawable.password else R.drawable.hide_password

                    Image(

                        painter = painterResource(id = icon),
                        contentDescription = ""

                    )
                    
                }
            }
            
        },

            maxLines = 1

    )

}



@Composable
@Preview
private fun CustomAuthInputPreview() {

    CustomAuthInput(image = R.drawable.profile, "Full Name", onValueChange = {})

}