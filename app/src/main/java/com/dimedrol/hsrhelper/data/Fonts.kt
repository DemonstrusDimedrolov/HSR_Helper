package com.dimedrol.hsrhelper.data

import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import com.dimedrol.hsrhelper.R

object AppFonts {
    val hsr = FontFamily(
        Font(R.font.poppins_black, FontWeight.Normal),
        Font(R.font.poppins_black_italic, FontWeight.Bold, FontStyle.Italic),
        Font(R.font.poppins_bold, FontWeight.Medium),
        Font(R.font.poppins_bold_italic, FontWeight.Black, FontStyle.Italic),
        Font(R.font.poppins_extra_bold, FontWeight.ExtraBold),
        Font(R.font.poppins_extra_bold_italic, FontWeight.Normal, FontStyle.Italic),
        Font(R.font.poppins_medium, FontWeight.Normal),
        Font(R.font.poppins_medium_italic, FontWeight.Normal, FontStyle.Italic)
    )
}