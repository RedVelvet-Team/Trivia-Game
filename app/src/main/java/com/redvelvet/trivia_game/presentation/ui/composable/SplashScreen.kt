package com.redvelvet.trivia_game.presentation.ui.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.redvelvet.presentation.R

@Composable
fun SplashScreen() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(R.drawable.trv_logo), // Replace with your logo resource
            contentDescription = "Logo",
            contentScale = ContentScale.Fit,
            modifier = Modifier
                .size(200.dp)
                .padding(16.dp)
                .wrapContentSize(Alignment.Center)
                .background(Color(0xFFFAFAFA), shape = CircleShape)
        )
    }
}