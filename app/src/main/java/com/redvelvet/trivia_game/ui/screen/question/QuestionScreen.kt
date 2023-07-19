package com.redvelvet.trivia_game.ui.screen.question

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.redvelvet.trivia_game.R
import com.redvelvet.trivia_game.ui.composable.QuestionAppBar
import com.redvelvet.trivia_game.ui.composable.QuestionChoices
import com.redvelvet.trivia_game.ui.composable.QuestionNumberText
import com.redvelvet.trivia_game.ui.screen.category.utils.SpaceVertical
import com.redvelvet.trivia_game.ui.screen.category.utils.TriviaUtils
import com.redvelvet.trivia_game.ui.theme.Poppins

@Composable
fun QuestionScreen(navController: NavController) {
    QuestionContent()

}

@Composable
fun QuestionContent() {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        QuestionAppBar("1200 Point")

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(1.dp)
                .background(Color(0xFFD9D9D9))
        )

        SpaceVertical(TriviaUtils.SPACE_56)

        Column(
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .fillMaxWidth()
                .background(
                    color = Color(0xFFF1F1F1),
                    shape = RoundedCornerShape(size = 12.dp)
                ),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            SpaceVertical(TriviaUtils.SPACE_32)

            Row {
                QuestionNumberText(text = "8")
                QuestionNumberText(text = " ${stringResource(R.string.out_of)} ")
                QuestionNumberText(text = "10")
            }

            SpaceVertical(TriviaUtils.SPACE_16)

            Text(
                text = "Who is the all-time leading goal scorer in the history of the UEFA Champions League?",
                textAlign = TextAlign.Center,
                fontSize = 16.sp,
                fontFamily = Poppins,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier.padding(horizontal = 16.dp)
            )
            SpaceVertical(TriviaUtils.SPACE_56)

            QuestionChoices(text = "Lionel Messi", spacer = 16)
            QuestionChoices(text = "Lionel Messi", spacer = 16)
            QuestionChoices(text = "Robert Lewandowski", spacer = 16)
            QuestionChoices(text = "Raul Gonzales", spacer = 56)
        }
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun PreviewQuestionScreen() {
    QuestionContent()
}