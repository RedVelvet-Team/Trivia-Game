package com.redvelvet.trivia_game.presentation.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.redvelvet.presentation.ui.screen.category.screenCategoryRoute
import com.redvelvet.presentation.ui.screen.question.SCREEN_KEY_QUESTION_SCREEN
import com.redvelvet.presentation.ui.screen.question.screenQuestionRoute

@Composable
fun TriviaNavGraph(navController: NavHostController){
    NavHost(navController = navController, startDestination = SCREEN_KEY_QUESTION_SCREEN){
        screenCategoryRoute(navController)
        screenQuestionRoute(navController)


    }
}