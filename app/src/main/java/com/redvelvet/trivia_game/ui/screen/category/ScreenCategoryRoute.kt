package com.redvelvet.trivia_game.ui.screen.category

import androidx.lifecycle.SavedStateHandle
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable

const val SCREEN_KEY_CATEGORY_SCREEN = "category_screen"


fun NavGraphBuilder.screenCategoryRoute(navController: NavController){
    composable(
        SCREEN_KEY_CATEGORY_SCREEN,
        arguments = emptyList()
    ){ CategoryScreen(navController) }
}


class CategoryScreenArgs(savedStateHandle: SavedStateHandle){

}