package com.redvelvet.trivia_game.ui.screen.lose

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.redvelvet.trivia_game.ui.composable.BackgroundColor
import com.redvelvet.trivia_game.ui.composable.LoseImage
import com.redvelvet.trivia_game.ui.composable.PlayAgainButton
import com.redvelvet.trivia_game.ui.composable.Rate
import com.redvelvet.trivia_game.ui.composable.TextConsolation
import com.redvelvet.trivia_game.ui.composable.TextResult


@Composable
fun LoseScreen(navController: NavHostController) {
    BackgroundColor()
    Box(modifier = Modifier.fillMaxHeight()) {
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
    //LoseScreen(navController)
}