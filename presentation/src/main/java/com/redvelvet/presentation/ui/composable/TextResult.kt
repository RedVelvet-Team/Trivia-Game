package com.redvelvet.presentation.ui.composable

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.redvelvet.presentation.ui.theme.Poppins


@Composable
fun TextResult(totalCorrectAnswer: String, totalQuestion: String) {
    Column(
        modifier = Modifier.padding(top = 32.dp, bottom = 16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Oops!",
            fontSize = 20.sp,
            fontFamily = Poppins,
            fontWeight = FontWeight.Medium,
            textAlign = TextAlign.Center
        )
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                text = "You scored",
                fontSize = 14.sp,
                color = Color.Black,
                fontFamily = Poppins,
                fontWeight = FontWeight.Medium
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = totalCorrectAnswer,
                fontSize = 14.sp,
                color = Color.Black,
                fontFamily = Poppins,
                fontWeight = FontWeight.Medium
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = "out of",
                fontSize = 14.sp,
                color = Color.Black,
                fontFamily = Poppins,
                fontWeight = FontWeight.Medium
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = totalQuestion,
                fontSize = 14.sp,
                color = Color.Black,
                fontFamily = Poppins,
                fontWeight = FontWeight.Medium
            )


        }
    }
}

@Preview
@Composable
fun PreviewTextResult() {
    TextResult("3", "11")
}