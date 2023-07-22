package com.redvelvet.trivia_game.ui.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight

import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.redvelvet.trivia_game.R
import com.redvelvet.trivia_game.ui.theme.*
import com.redvelvet.trivia_game.ui.theme.Poppins

@Composable
fun Rate(result: String) {
    Row(modifier = Modifier.fillMaxWidth()) {
        Box(modifier = Modifier) {
            Image(
                painter = painterResource(id = R.drawable.ic_starr),
                contentDescription = "result image",
                modifier = Modifier.size(28.dp)
            )
        }
        Spacer(modifier = Modifier.width(8.dp))
        Box(modifier = Modifier, contentAlignment = Alignment.BottomCenter) {
            Text(
                text = result,
                modifier = Modifier.padding(start = 8.dp),
                fontFamily = Poppins,
                fontWeight = FontWeight.SemiBold,
                fontSize = 20.sp,
                color = Color.Black
            )
        }
    }
}

@Preview
@Composable
fun PreviewRate() {
    Rate(result = "1200")
}




