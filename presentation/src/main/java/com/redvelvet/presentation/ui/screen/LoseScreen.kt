package com.redvelvet.presentation.ui.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.redvelvet.presentation.ui.composable.BackgroundColor
import com.redvelvet.presentation.ui.composable.LoseImage
import com.redvelvet.presentation.ui.composable.PlayAgainButton
import com.redvelvet.presentation.ui.composable.Rate
import com.redvelvet.presentation.ui.composable.TextConsolation
import com.redvelvet.presentation.ui.composable.TextResult


@Composable
fun LoseScreen() {

    Box(modifier = Modifier.fillMaxHeight()) {
        BackgroundColor()
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(start = 16.dp, top = 16.dp, end = 16.dp)
        ) {
            Rate(result = "1200")
            LoseImage()
            TextResult(totalCorrectAnswer = "3", totalQuestion = "11")
            TextConsolation()
            PlayAgainButton()
        }

    }


}

@Preview(showSystemUi = true)
@Composable
fun PreviewLoseScreen() {
    LoseScreen()
}