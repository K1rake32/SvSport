package com.example.svsport.ui.app.screens.Auth.PhoneMask

import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.input.OffsetMapping
import androidx.compose.ui.text.input.TransformedText
import androidx.compose.ui.text.input.VisualTransformation

class PhoneMaskTransformation : VisualTransformation {
    override fun filter(text: AnnotatedString): TransformedText {
        val digits = text.text.filter { it.isDigit() }
        val transformedText = buildString {
            if (digits.isNotEmpty()) append("+7 ")
            for (i in digits.indices) {
                when (i) {
                    3, 6 -> append(" ")
                    8 -> append(" ")
                }
                append(digits[i])
            }
        }

        // Создание корректного OffsetMapping
        val offsetMapping = object : OffsetMapping {
            override fun originalToTransformed(offset: Int): Int {
                if (offset == 0) return 0
                val transformedOffset = when {
                    offset <= 1 -> offset + 3
                    offset <= 4 -> offset + 4
                    offset <= 7 -> offset + 5
                    else -> offset + 6
                }
                return transformedOffset.coerceAtMost(transformedText.length)
            }

            override fun transformedToOriginal(offset: Int): Int {
                if (offset <= 3) return 0 // До +7
                val originalOffset = when {
                    offset <= 7 -> offset - 3
                    offset <= 11 -> offset - 4
                    offset <= 15 -> offset - 5
                    else -> offset - 6
                }
                return originalOffset.coerceAtMost(digits.length)
            }
        }

        return TransformedText(AnnotatedString(transformedText), offsetMapping)
    }
}