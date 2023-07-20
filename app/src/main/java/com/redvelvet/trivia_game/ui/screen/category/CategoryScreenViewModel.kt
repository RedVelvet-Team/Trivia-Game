package com.redvelvet.trivia_game.ui.screen.category

import android.util.Log
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class CategoryScreenViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle
) : ViewModel() {
    private val _state = MutableStateFlow(CategoryUIState())
    val state = _state.asStateFlow()
    private val _mode = MutableStateFlow("")
    val mode = _mode.asStateFlow()

    init {
        getCategories()
        getChips()
        val args = requireNotNull(savedStateHandle["mode"]) as String
        _mode.update { args }
        Log.w("HASSAN",mode.value)
    }

    private fun getCategories() {
        _state.update { it.copy(categories = CategoryFactory().newCategories) }
    }

    private fun getChips() {
        _state.update { it.copy(chips = CategoryFactory().newChips) }
    }

    fun onCategoryItemClicked(category: CategoryUIState.CategoryItemUIState) {
        if (category.selected) {
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
                    it.copy(selected = !it.selected)
                } else {
                    it
                }
            }
            val selectedCategories = updatedCategories.filter { it.selected }
            state.copy(categories = updatedCategories, selectedCategories = selectedCategories)
        }
    }

    private fun enableAllCategories() {
        _state.update { state ->
            state.copy(categories = state.categories.map { it.copy(enabled = true) })
        }
    }

    private fun disableNotSelectedCategories() {
        _state.update { state ->
            state.copy(
                categories = state.categories.map {
                    if (it.selected) it.copy(enabled = true)
                    else it.copy(enabled = false)
                }
            )
        }
    }

    fun onChipItemClicked(chip: CategoryUIState.ChipItemUIState) {
        _state.update { state ->
            val updatedChips = state.chips.map {
                if (it.id == chip.id) {
                    it.copy(selected = !it.selected)
                } else {
                    it
                }
            }
            val selectedChips = updatedChips.filter { it.selected }
            state.copy(chips = updatedChips, selectedChips = selectedChips)
        }
    }
}

