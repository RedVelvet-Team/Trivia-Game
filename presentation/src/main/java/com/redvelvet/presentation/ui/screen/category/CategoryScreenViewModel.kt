package com.redvelvet.presentation.ui.screen.category

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class CategoryScreenViewModel @Inject constructor() : ViewModel() {
    private val _state = MutableStateFlow(CategoryUIState())
    val state = _state.asStateFlow()

    init {
        getCategories()
        getChips()
    }

    private fun getCategories() {
        _state.update { it.copy(categories = CategoryFactory().newCategories) }
    }

    private fun getChips() {
        _state.update { it.copy(chips = CategoryFactory().newChips) }
    }

    fun onCategoryItemClicked(category: CategoryUIState.CategoryItemUIState) {
        if (category.isSelected) {
            toggleCategorySelection(category)
            enableAllCategories()
        } else if (state.value.isMaxSelectionReached.not()) {
            toggleCategorySelection(category)
            if (state.value.isMaxSelectionReached) disableNotSelectedCategories()
        }
    }

    private fun toggleCategorySelection(category: CategoryUIState.CategoryItemUIState) {
        _state.update { state ->
            val updatedCategories = state.categories.map {
                if (it.id == category.id) {
                    it.copy(isSelected = !it.isSelected)
                } else {
                    it
                }
            }
            val selectedCategories = updatedCategories.filter { it.isSelected }
            state.copy(categories = updatedCategories, selectedCategories = selectedCategories)
        }
    }

    private fun enableAllCategories() {
        _state.update { state ->
            state.copy(categories = state.categories.map { it.copy(isEnabled = true) })
        }
    }

    private fun disableNotSelectedCategories() {
        _state.update { state ->
            state.copy(
                categories = state.categories.map {
                    if (it.isSelected) it.copy(isEnabled = true)
                    else it.copy(isEnabled = false)
                }
            )
        }
    }

    fun onChipItemClicked(chip: CategoryUIState.ChipItemUIState) {
        _state.update { state ->
            val updatedChips = state.chips.map {
                if (it.id == chip.id) {
                    it.copy(isSelected = !it.isSelected)
                } else {
                    it
                }
            }
            val selectedChips = updatedChips.filter { it.isSelected }
            state.copy(chips = updatedChips, selectedChips = selectedChips)
        }
    }
}

