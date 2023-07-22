package com.redvelvet.trivia_game.ui.screen.configuration

import androidx.annotation.DrawableRes
import androidx.lifecycle.ViewModel
import com.redvelvet.trivia_game.R
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

class ConfigurationScreenViewModel @Inject constructor(): ViewModel(){

    private val _data:MutableStateFlow<List<GameMode>> = MutableStateFlow(listOf(
        GameMode(
            title = "Casual Mode",
            description = "Take your time, explore diverse topics, collect more points, and enjoy a stress-free trivia experience!",
            icon = R.drawable.causal_mode
        ),
        GameMode(
            title = "Timed Mode",
            description = "Test your speed, gather knowledge, and collect points before the timer runs out. if time expires, you lose!",
            icon = R.drawable.timed_mode
        ),
        GameMode(
            title = "Survival Mode",
            description = "Answer correctly to stay in game, any wrong answer means you’re out. See how long you can survive!",
            icon = R.drawable.survival_mode
        )
    ))
    val data = _data.asStateFlow()

    private val _selectedMode:MutableStateFlow<String> = MutableStateFlow("Casual Mode")
    val selectedMode = _selectedMode.asStateFlow()


    fun selectMode(mode: String){
        _selectedMode.update { mode }
    }



}

data class GameMode(
    val title: String,
    val description: String,
    @DrawableRes val icon: Int,
    val selected: Boolean = false
)