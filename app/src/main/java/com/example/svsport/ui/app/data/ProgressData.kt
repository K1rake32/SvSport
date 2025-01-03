package com.example.svsport.ui.app.data

import androidx.compose.runtime.Composable

data class ProgressData(

    val canvasContent: @Composable () -> Unit,
    val  text: String

)
