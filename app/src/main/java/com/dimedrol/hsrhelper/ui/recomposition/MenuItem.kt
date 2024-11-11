package com.dimedrol.hsrhelper.ui.recomposition

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.dimedrol.hsrhelper.data.AppFonts

@Composable
fun MenuItem(
    url: String,
    description: String,
    onClick: () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 16.dp, end = 16.dp, top = 8.dp)
            .background(Color(0xff33343a))
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(2.dp)
                .background(Color(0xff2c2d33))
                .clickable {
                    onClick()
                },
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start,

            ) {
            AsyncImage(
                model = url,
                contentDescription = null,
                contentScale = ContentScale.Fit,
                modifier = Modifier
                    .size(70.dp)
            )

            Text(
                modifier = Modifier
                    .padding(start = 10.dp),
                text = description,
                fontFamily = AppFonts.hsr,
                fontWeight = FontWeight.Medium,
                color = Color.White,
                fontSize = 24.sp
            )
        }
    }
}