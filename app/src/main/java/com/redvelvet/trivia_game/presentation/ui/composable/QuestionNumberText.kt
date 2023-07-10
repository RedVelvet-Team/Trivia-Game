package com.redvelvet.trivia_game.presentation.ui.composable

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import com.redvelvet.trivia_game.presentation.ui.theme.Poppins


@Composable
fun QuestionNumberText(text: String) {
    Text(
        text = text,
        fontSize = 16.sp,
        fontWeight = FontWeight.Medium,
        textAlign = TextAlign.Center,
        color = Color(0x66212121),
        fontFamily = Poppins
    )
}