package com.redvelvet.trivia_game.ui.composable

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Surface
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.redvelvet.trivia_game.R
import com.redvelvet.trivia_game.ui.theme.OnBackgroundLight
import com.redvelvet.trivia_game.ui.theme.Poppins
import com.redvelvet.trivia_game.ui.theme.Primary

@Composable
fun CustomDetailsScoreButton() {
    val buttonShape = RoundedCornerShape(topStart = 32.dp, bottomStart = 32.dp)

    val iconModifier = Modifier
        .background(Color.White, shape = RoundedCornerShape(50))
        .padding(8.dp)

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp),
        horizontalArrangement = Arrangement.End,
        verticalAlignment = Alignment.CenterVertically
    ) {

        Button(
            onClick = { /*TODO*/ },
            shape = buttonShape,
            colors = ButtonDefaults.buttonColors(containerColor = OnBackgroundLight),
            border = BorderStroke(0.dp, Color.Transparent)
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Surface(
                    modifier = Modifier.size(50.dp),
                    shape = CircleShape,
                    border = BorderStroke(width = 4.dp, color = Color.Yellow),
                    color = Color.Transparent
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_starr),
                        contentDescription = null,
                        modifier = iconModifier,
                        tint = Color.Yellow
                    )
                }
                Text(
                    text = "1200 Total points",
                    modifier = Modifier.padding(horizontal = 16.dp),
                    color = Primary,
                    fontSize = 16.sp,
                    fontFamily = Poppins,
                    fontWeight = FontWeight.Medium,
                )
            }
        }
    }
}