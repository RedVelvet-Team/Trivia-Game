package com.redvelvet.presentation.ui.screen.category

data class CategoryUIState(
    val categories: List<CategoryItemUIState> = emptyList(),
    val selectedCategories: List<CategoryItemUIState> = emptyList(),
) {
    val isMaxSelectionReached = selectedCategories.size == 3
    val isStartButtonEnabled = selectedCategories.isNotEmpty()

    data class CategoryItemUIState(
        val id: Int = 0,
        val name: String = "",
        val icon: Int = 0,
        val isEnabled: Boolean = true,
        val isSelected: Boolean = false,
    )
}