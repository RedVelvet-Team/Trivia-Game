package com.redvelvet.trivia_game.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.redvelvet.trivia_game.ui.screen.category.SCREEN_KEY_CATEGORY_SCREEN
import com.redvelvet.trivia_game.ui.screen.category.screenCategoryRoute
import com.redvelvet.trivia_game.ui.screen.question.screenQuestionRoute


@Composable
fun TriviaNavGraph(navController: NavHostController){
    NavHost(navController = navController, startDestination = SCREEN_KEY_CATEGORY_SCREEN){
        screenCategoryRoute(navController)
        screenQuestionRoute(navController)
    }
}
