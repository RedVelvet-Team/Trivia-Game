package com.redvelvet.trivia_game.presentation.ui.screen.question

import androidx.lifecycle.SavedStateHandle
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument

const val SCREEN_KEY_QUESTION_SCREEN = "question_screen"
const val KEY_SELECTED_CHIPS = "selected_chips"
const val KEY_SELECTED_CATEGORIES = "selected_categories"

fun NavGraphBuilder.screenQuestionRoute(navController: NavController){
    composable(
        "$SCREEN_KEY_QUESTION_SCREEN/$KEY_SELECTED_CHIPS/$KEY_SELECTED_CATEGORIES",
        arguments = listOf(
            navArgument(KEY_SELECTED_CHIPS){NavType.StringType},
            navArgument(KEY_SELECTED_CATEGORIES){NavType.StringType},
            )
    ){QuestionScreen(navController)}
}


class QuestionScreenArgs(savedStateHandle: SavedStateHandle){
    val selectedChips:String = checkNotNull(savedStateHandle[KEY_SELECTED_CHIPS])
    val selectedCategories:String = checkNotNull(savedStateHandle[KEY_SELECTED_CATEGORIES])

}