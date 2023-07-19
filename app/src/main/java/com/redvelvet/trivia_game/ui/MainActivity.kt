package com.redvelvet.trivia_game.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import com.redvelvet.trivia_game.ui.navigation.TriviaNavGraph
import com.redvelvet.trivia_game.ui.screen.configuration.ConfigurationScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ConfigurationScreen()
//            val navController = rememberNavController()
//            TriviaNavGraph(navController = navController)
        }
    }
}