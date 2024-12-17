package com.example.svsport.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.svsport.R

//fonts

val PoppinsBold = FontFamily(

    Font(R.font.poppins_bold, FontWeight.Bold)

)

val PoppinsRegular = FontFamily(

    Font(R.font.poppins_regular, FontWeight.Normal)

)

val brush = Brush.linearGradient(listOf(PurpleButton, PinkButton))

val Typography = Typography(
    bodyLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    )

)

val Typography.MainOnBoarding: TextStyle
    get() = TextStyle(
        fontSize = 24.sp,
        color = Color.Black,
        fontFamily = PoppinsBold
    )

val Typography.MinorOnBoarding: TextStyle
    get() = TextStyle(
        fontSize = 14.sp,
        color = Color.Gray,
        fontFamily = PoppinsRegular
    )

val Typography.MinorAuth: TextStyle
    get() = TextStyle(
        fontSize = 16.sp,
        color = Color.Black,
        fontFamily = PoppinsRegular
    )

val Typography.MainAuth: TextStyle
    get() = TextStyle(
        fontSize = 20.sp,
        color = Color.Black,
        fontFamily = PoppinsBold
    )

val Typography.InputAuthText: TextStyle
    get() = TextStyle(
        fontSize = 12.sp,
        color = GrayTextAuth,
        fontFamily = PoppinsRegular
    )

val Typography.TeamConditionText: TextStyle
    get() = TextStyle(
        fontSize = 10.sp,
        color = GrayTextAuth,
        fontFamily = PoppinsRegular
    )

val Typography.ButtonNextText: TextStyle
    get() = TextStyle(
        fontSize = 16.sp,
        color = Color.White,
        fontFamily = PoppinsBold
    )

val Typography.MainWelcomeText: TextStyle
    get() = TextStyle(
        fontSize = 36.sp,
        brush = brush,
        fontFamily = PoppinsBold
    )

val Typography.MinorWelcomeText: TextStyle
    get() = TextStyle(
        fontSize = 18.sp,
        color = WelcomeGray,
        fontFamily = PoppinsRegular
    )

val Typography.AuthMainText: TextStyle
    get() = TextStyle(
        fontSize = 20.sp,
        color = Color.Black,
        fontFamily = PoppinsBold
    )

val Typography.AuthMinorText: TextStyle
    get() = TextStyle(
        fontSize = 12.sp,
        color = GrayBLack,
        fontFamily = PoppinsRegular
    )


