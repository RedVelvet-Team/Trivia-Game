package com.redvelvet.presentation.ui.screen.category

data class CategoryUIState(
    val categories: List<CategoryItemUIState> = emptyList(),
    val selectedCategories: List<CategoryItemUIState> = emptyList(),
    val chips: List<ChipItemUIState> = emptyList(),
    val selectedChips: List<ChipItemUIState> = emptyList(),
) {
    val isMaxSelectionReached = selectedCategories.size == 3
    val isStartButtonEnabled = selectedCategories.isNotEmpty() && selectedChips.isNotEmpty()

    data class CategoryItemUIState(
        val id: Int = 0,
        val name: String = "",
        val icon: Int = 0,
        val enabled: Boolean = true,
        val selected: Boolean = false,
    )

    data class ChipItemUIState(
        val id: Int = 0,
        val name: String = "",
        val selected: Boolean = false,
    )
}