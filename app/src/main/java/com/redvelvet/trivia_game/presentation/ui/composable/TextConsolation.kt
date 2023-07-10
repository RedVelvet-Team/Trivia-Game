package com.redvelvet.trivia_game.presentation.ui.composable

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.redvelvet.presentation.R
import com.redvelvet.presentation.ui.theme.DarkGray
import com.redvelvet.presentation.ui.theme.Poppins

@Composable
fun TextConsolation(){
    Text(
        text = stringResource(R.string.text_consolation),
        maxLines = 3,
        fontFamily = Poppins,
        fontSize = 14.sp,
        fontWeight = FontWeight.Normal,
        color = DarkGray,
        modifier = Modifier.padding(horizontal = 32.dp, vertical = 32.dp),
        textAlign = TextAlign.Center
    )
}

@Preview
@Composable
fun PreviewTextConsolation(){
    TextConsolation()
}