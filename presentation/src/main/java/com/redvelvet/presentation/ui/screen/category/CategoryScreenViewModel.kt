package com.redvelvet.presentation.ui.screen.category

import android.util.Log
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
        Log.d("ChipItemClicked", chip.toString())
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

    /*
    * Old Implementation
    * */

//    private val _selectedChoices: MutableStateFlow<MutableList<CategoryItem>> =
//        MutableStateFlow(mutableListOf())
//    val selectedChoices = _selectedChoices.asStateFlow()
//
//    private val _categories: MutableStateFlow<List<CategoryItem>> =
//        MutableStateFlow(CategoryFactory().categories)
//    val categories = _categories.asStateFlow()
//
//    private val _selectedLevelIndex: MutableStateFlow<Int> = MutableStateFlow(0)
//    val selectedLevelIndex = _selectedLevelIndex.asStateFlow()

//    fun selectLevelChip(index: Int) {
//        _selectedLevelIndex.value = index
//    }

//    fun toggleChoiceSelection(choice: CategoryItem) {
//        if (_selectedChoices.value.contains(choice)) {
//            _selectedChoices.value.remove(choice)
//            enableAllChoices()
//        } else if (_selectedChoices.value.size <= 3) {
//            _selectedChoices.value.add(choice)
//            if (_selectedChoices.value.size == 3) {
//                disableUnselectedChoices()
//            }
//        }
//        Log.i("X15", _selectedChoices.value.toString())
//    }

//    private fun enableAllChoices() {
//        _categories.value = _categories.value.map { it.copy(isEnabled = true) }
//    }

//    private fun disableUnselectedChoices() {
//        val selectedIds = _selectedChoices.value.map { it.id }
//        _categories.value = _categories.value.map {
//            if (selectedIds.contains(it.id)) {
//                it.copy(isEnabled = true)
//            } else {
//                it.copy(isEnabled = false)
//            }
//        }
//    }
}

