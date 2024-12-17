package com.example.svsport.ui.app.CustomUI

import androidx.compose.foundation.clickable
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.CacheDrawModifierNode
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.svsport.ui.theme.Gray
import com.example.svsport.ui.theme.GrayTextAuth

@Composable
fun CustomAuthCheckbox(

    isChecked: Boolean,
    onCheckedChange:(Boolean) -> Unit

) {

    Checkbox(

        checked = isChecked,
        onCheckedChange = { newState ->

            onCheckedChange(newState)

        },

        colors = CheckboxDefaults.colors(

            checkedColor =  Color.LightGray,
            uncheckedColor = GrayTextAuth,
            checkmarkColor = Color.Black
        )

    )

}

@Composable
@Preview
private fun CustomAuthCheckboxPreview() {

    var isChecked by remember { mutableStateOf(false) }

    CustomAuthCheckbox(

        isChecked = isChecked,
        onCheckedChange = { isChecked = it }

    )

}