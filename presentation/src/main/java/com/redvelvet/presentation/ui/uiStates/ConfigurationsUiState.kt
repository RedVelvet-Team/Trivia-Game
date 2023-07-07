package com.redvelvet.presentation.ui.uiStates

data class ConfigurationsUiState(
    val modes: List<ConfigurationUiState> = emptyList(),
    val selected: ConfigurationMode = ConfigurationMode.CASUAL_MODE
)

data class ConfigurationUiState(
    val mode: ConfigurationMode = ConfigurationMode.CASUAL_MODE,
    val modeDescription: String = "",
    val modeImage:Int = 0
)

enum class ConfigurationMode{
    CASUAL_MODE,
    TIMED_MODE,
    SURVIVAL_MODE
}