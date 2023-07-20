package com.redvelvet.trivia_game.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.redvelvet.trivia_game.ui.navigation.Keys.Arg_Categories
import com.redvelvet.trivia_game.ui.navigation.Keys.Arg_Chips
import com.redvelvet.trivia_game.ui.navigation.Keys.Arg_Mode
import com.redvelvet.trivia_game.ui.screen.category.CategoryScreen
import com.redvelvet.trivia_game.ui.screen.configuration.ConfigurationScreen
import com.redvelvet.trivia_game.ui.screen.question.QuestionScreen

object Keys{
    const val Arg_Mode = "mode"
    const val Arg_Chips = "chips"
    const val Arg_Categories = "categories"
}

@Composable
fun Navigation(){
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Screen.ScreenConfiguration.route
    ){

        composable(
            route = Screen.ScreenConfiguration.route,
            arguments = emptyList()
        ){
            ConfigurationScreen(navController = navController)
        }

        composable(
            route = Screen.ScreenCategory.route + "/{$Arg_Mode}",
            arguments = listOf(
                navArgument(Arg_Mode){
                    type = NavType.StringType
                    defaultValue = "Casual"
                }
            )
        ){ CategoryScreen(navController = navController)}

        composable(
            Screen.ScreenQuestion.route + "/{$Arg_Mode}/{$Arg_Chips}/{$Arg_Categories}",
            arguments = listOf(
                navArgument(Arg_Mode){
                    type = NavType.StringType
                    defaultValue = "Casual Mode"
                },
                navArgument(Arg_Chips){
                    type = NavType.StringType
                    defaultValue = "Easy"
                },
                navArgument(Arg_Categories){
                    type = NavType.StringType
                    defaultValue = "History"
                },
            )
        ){ QuestionScreen(navController = navController) }
    }
}