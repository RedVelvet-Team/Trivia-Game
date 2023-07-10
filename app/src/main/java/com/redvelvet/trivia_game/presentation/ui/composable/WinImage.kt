package com.redvelvet.trivia_game.presentation.ui.composable

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource

@Composable
fun ImageWin(
    imageUrl: Int,
    description: String,
    modifier: Modifier = Modifier
    ){
    Image(
        painter = painterResource(id = imageUrl),
        contentDescription = description,
        modifier = modifier,
        contentScale = ContentScale.FillBounds
    )
}