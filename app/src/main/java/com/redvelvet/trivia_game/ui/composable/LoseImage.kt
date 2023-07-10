package com.redvelvet.trivia_game.ui.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.redvelvet.trivia_game.R


@Composable
fun LoseImage() {
    Box(modifier = Modifier.fillMaxWidth().padding(top = 96.dp), contentAlignment = Alignment.Center) {
        Image(
            painter = painterResource(id = R.drawable.ic_cuate),
            contentDescription = "Lose game image"
        )
    }
}


@Preview
@Composable
fun PreviewLoseImage() {
    LoseImage()
}