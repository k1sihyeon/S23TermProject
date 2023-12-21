package kr.ac.kumoh.ce.s23termproject.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import kr.ac.kumoh.ce.s23termproject.R

val pretendardBlack = FontFamily(Font(R.font.pretendard_black))
val pretendardExBold = FontFamily(Font(R.font.pretendard_extrabold))
val pretendardBold = FontFamily(Font(R.font.pretendard_bold))
val pretendardSeBold = FontFamily(Font(R.font.pretendard_semibold))
val pretendardM = FontFamily(Font(R.font.pretendard_medium))
val pretendardR = FontFamily(Font(R.font.pretendard_regular))


// Set of Material typography styles to start with
val Typography = Typography(
    bodyLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    )
    /* Other default text styles to override
    titleLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 22.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.sp
    ),
    labelSmall = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Medium,
        fontSize = 11.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp
    )
    */
)