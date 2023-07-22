package com.redvelvet.trivia_game.ui.navigation

sealed class Screen(val route: String){
    object ScreenConfiguration: Screen("screen_config")
    object ScreenCategory: Screen("screen_category")
    object ScreenQuestion: Screen("screen_question")
    object ScreenWin: Screen("screen_win")
    object ScreenLose: Screen("screen_lose")


    fun withArgs(vararg arg: String): String{
        return buildString {
            append(route)
            arg.forEach {
                append("/$it")
            }
        }
    }
}
