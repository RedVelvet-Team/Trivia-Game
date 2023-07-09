package com.redvelvet.presentation.ui.screen.category

import android.util.Log
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class CategoryScreenViewModel @Inject constructor() : ViewModel() {

    private val _selectedChoices: MutableStateFlow<MutableList<CategoryItem>> =
        MutableStateFlow(mutableListOf())
    val selectedChoices = _selectedChoices.asStateFlow()

    private val _categories: MutableStateFlow<List<CategoryItem>> =
        MutableStateFlow(CategoryFactory().categories)
    val categories = _categories.asStateFlow()

    private val _selectedLevelIndex: MutableStateFlow<Int> = MutableStateFlow(0)
    val selectedLevelIndex = _selectedLevelIndex.asStateFlow()

    fun selectLevelChip(index: Int) {
        _selectedLevelIndex.value = index
    }

    fun toggleChoiceSelection(choice: CategoryItem) {
        if (_selectedChoices.value.contains(choice)) {
            _selectedChoices.value.remove(choice)
            enableAllChoices()
        } else if (_selectedChoices.value.size <= 3) {
            _selectedChoices.value.add(choice)
            if (_selectedChoices.value.size == 3) {
                disableUnselectedChoices()
            }
        }
        Log.i("X15",_selectedChoices.value.toString())
    }

    private fun enableAllChoices() {
        _categories.value = _categories.value.map { it.copy(isEnabled = true) }
    }

    private fun disableUnselectedChoices() {
        val selectedIds = _selectedChoices.value.map { it.id }
        _categories.value = _categories.value.map {
            if (selectedIds.contains(it.id)) {
                it.copy(isEnabled = true)
            } else {
                it.copy(isEnabled = false)
            }
        }
    }
}

