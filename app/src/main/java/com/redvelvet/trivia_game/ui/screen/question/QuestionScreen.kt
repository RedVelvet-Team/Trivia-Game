package com.redvelvet.trivia_game.ui.screen.question

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.redvelvet.trivia_game.R
import com.redvelvet.trivia_game.ui.composable.QuestionAppBar
import com.redvelvet.trivia_game.ui.composable.QuestionChoices
import com.redvelvet.trivia_game.ui.composable.QuestionNumberText
import com.redvelvet.trivia_game.ui.navigation.Screen
import com.redvelvet.trivia_game.ui.screen.category.utils.SpaceVertical
import com.redvelvet.trivia_game.ui.screen.category.utils.TriviaUtils
import com.redvelvet.trivia_game.ui.theme.Poppins

@Composable
fun QuestionScreen(
    viewModel: QuestionScreenViewModel = hiltViewModel(),
    navController: NavController
) {
    val currentNumber = viewModel.questionManager.collectAsState().value.currentQuestion + 1
    val isLast = viewModel.questionManager.collectAsState().value.lastQuestion
    val correct = viewModel.currentQuestion.collectAsState().value.correct
    val total = viewModel.data.collectAsState().value.questionList.size
    val currentQuestion = viewModel.currentQuestion.collectAsState().value

    QuestionContent(
        currentNumber = currentNumber,
        total = total,
        currentQuestion,
        viewModel::checkAnswer)

    if (isLast && (correct > (total * 0.8))) {
        navController.navigate(Screen.ScreenWin.route)
    } else if(isLast && (correct < (total * 0.8))){
        navController.navigate(Screen.ScreenLose.route)
    }
}

@Composable
fun QuestionContent(
    currentNumber: Int,
    total: Int,
    currentQuestion: QuestionState,
    onAnswerClick: (String)-> Unit) {

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
                QuestionNumberText(text = currentNumber.toString())
                QuestionNumberText(text = " ${stringResource(R.string.out_of)} ")
                QuestionNumberText(text = total.toString())
            }

            SpaceVertical(TriviaUtils.SPACE_16)

            Text(
                text = currentQuestion.question.question,
                textAlign = TextAlign.Center,
                fontSize = 16.sp,
                fontFamily = Poppins,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier.padding(horizontal = 16.dp)
            )
            SpaceVertical(TriviaUtils.SPACE_56)

            val list = currentQuestion.question.incorrectAnswers + currentQuestion.question.correctAnswer
            list.shuffled().forEach {
                QuestionChoices(text = it, spacer = 16,currentQuestion.type) {
                    onAnswerClick(it)
                }
            }
            Spacer(modifier = Modifier.height(40.dp))
        }
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun PreviewQuestionScreen() {
    //QuestionContent(0, 0, currentQuestion)
}