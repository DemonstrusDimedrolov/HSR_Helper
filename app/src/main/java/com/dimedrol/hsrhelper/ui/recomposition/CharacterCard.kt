package com.dimedrol.hsrhelper.ui.recomposition

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.dimedrol.hsrhelper.data.AppFonts

@Composable
fun CharacterCard(name: String, character: String, element: String, rare: String) {
    Card(
        modifier = Modifier
            .padding(4.dp),
        shape = RoundedCornerShape(10.dp)
    ) {
        if (rare == "5") {
            Box(
                modifier = Modifier
                    .background(
                        brush = Brush.verticalGradient(
                            colors = listOf(Color(0xFFA57D01), Color(0xFFF8E473)),
                            startY = 0f,
                            endY = 700f
                        )
                    )
            ) {

                AsyncImage(
                    model = character,
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxWidth(),
                    contentScale = ContentScale.Crop
                )

                AsyncImage(
                    model = element,
                    contentDescription = null,
                    modifier = Modifier
                        .padding(2.dp)
                        .size(40.dp)
                )

                Text(
                    text = name,
                    color = Color.White,
                    fontSize = 18.sp,
                    fontFamily = AppFonts.hsr,
                    fontWeight = FontWeight.Bold,
                    style = TextStyle(
                        shadow = Shadow(
                            color = Color.Black,
                            offset = Offset(1f, 4f),
                            blurRadius = 4f
                        )
                    ),
                    modifier = Modifier
                        .align(Alignment.BottomCenter)
                        .padding(bottom = 4.dp)
                )
            }
        } else if (rare == "4") {
            Box(
                modifier = Modifier
                    .background(
                        brush = Brush.verticalGradient(
                            colors = listOf(Color(0xFF3A1C52), Color(0xFF7A4A8D)),
                            startY = 0f,
                            endY = 300f
                        )
                    )
            ) {
                AsyncImage(
                    model = character,
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxWidth(),
                    contentScale = ContentScale.Crop
                )

                AsyncImage(
                    model = element,
                    contentDescription = null,
                    modifier = Modifier
                        .padding(2.dp)
                        .size(40.dp)
                )

                Text(
                    text = name,
                    color = Color.White,
                    fontSize = 18.sp,
                    fontFamily = AppFonts.hsr,
                    fontWeight = FontWeight.Bold,
                    style = TextStyle(
                        shadow = Shadow(
                            color = Color.Black,
                            offset = Offset(1f, 4f),
                            blurRadius = 4f
                        )
                    ),
                    modifier = Modifier
                        .align(Alignment.BottomCenter)
                        .padding(bottom = 4.dp)
                )
            }
        }
    }
}