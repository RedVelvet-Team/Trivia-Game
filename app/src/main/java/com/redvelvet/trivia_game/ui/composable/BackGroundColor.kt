package com.redvelvet.trivia_game.ui.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.redvelvet.trivia_game.R


@Composable
fun BackgroundColor() {
    Box(
        modifier = Modifier
            .fillMaxWidth(),
        contentAlignment = Alignment.TopCenter
    ) {
        Image(
            painter = painterResource(id = R.drawable.ellipse_65),
            contentDescription = "background color",
            modifier = Modifier.fillMaxWidth(),
            contentScale = ContentScale.FillWidth,

            )
    }

}


@Preview(showSystemUi = true)
@Composable
fun PreviewBackgroundColor() {
    BackgroundColor()
}