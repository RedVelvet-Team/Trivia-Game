package com.redvelvet.presentation.ui.screens

import androidx.lifecycle.ViewModel
import com.redvelvet.presentation.ui.uiStates.ConfigurationMode
import com.redvelvet.presentation.ui.uiStates.ConfigurationUiState
import com.redvelvet.presentation.ui.uiStates.ConfigurationsUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

@HiltViewModel
class ConfigurationsViewModel : ViewModel() {
    private val _state = MutableStateFlow(ConfigurationsUiState())
    val state = _state.asStateFlow()

    init {
        getAllModes()
    }

    private fun getAllModes() {
        val modes = listOf(
            ConfigurationUiState(
                mode = ConfigurationMode.CASUAL_MODE,
                modeDescription = "Take your time, explore diverse topics, collect more points, and enjoy a stress-free trivia experience!"
            ),
            ConfigurationUiState(
                mode = ConfigurationMode.TIMED_MODE,
                modeDescription = "Test your speed, gather knowledge, and collect points before the timer runs out. if time expires, you lose!"
            ),
            ConfigurationUiState(
                mode = ConfigurationMode.SURVIVAL_MODE,
                modeDescription = "Answer correctly to stay in game, any wrong answer means you’re out. See how long you can survive!"
            ),
        )
        _state.update { it.copy(modes = modes) }
    }
}