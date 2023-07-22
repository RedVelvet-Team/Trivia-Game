package com.redvelvet.trivia_game.ui.composable

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import com.redvelvet.trivia_game.ui.theme.*
import com.redvelvet.trivia_game.ui.theme.Poppins

@Composable
fun WinText14Sp(
    stringResource: Int,
    fontWeight: FontWeight = FontWeight.Medium,
    modifier: Modifier = Modifier,
    color: Color = Color.Unspecified
){
    Text(
        text = stringResource(stringResource),
        textAlign = TextAlign.Center,
        fontFamily = Poppins,
        fontWeight = fontWeight,
        fontSize = 14.sp,
        modifier = modifier.fillMaxWidth(),
        color = color
    )
}