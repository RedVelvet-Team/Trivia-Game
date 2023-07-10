package com.redvelvet.trivia_game.presentation.ui.composable

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import com.redvelvet.presentation.ui.theme.Poppins

@Composable
fun WinText20Sp(
    textResource: Int,
    fontWeight: FontWeight = FontWeight.Medium,
    modifier: Modifier = Modifier
){
    Text(
        text = stringResource(id = textResource),
        textAlign = TextAlign.Center,
        fontFamily = Poppins,
        fontWeight = fontWeight,
        fontSize = 20.sp,
        modifier = modifier
    )
}