package com.redvelvet.presentation.ui.uiStates

data class ConfigurationsUiState(
    val modes: List<ConfigurationUiState> = emptyList()
)

data class ConfigurationUiState(
    val mode: ConfigurationMode = ConfigurationMode.CASUAL_MODE,
    val modeDescription: String = ""
)

enum class ConfigurationMode{
    CASUAL_MODE,
    TIMED_MODE,
    SURVIVAL_MODE
}