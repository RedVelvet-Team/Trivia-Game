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

    fun toggleChoiceSelection(choice: CategoryItem) {
        if (_selectedChoices.value.contains(choice)) {
            _selectedChoices.value.remove(choice)
            Log.i("X15","REMOVE + ENABLE")
            enableAllChoices()
        } else if (_selectedChoices.value.size <= 3) {
            _selectedChoices.value.add(choice)
            Log.i("X15","ADD + DISABLE")
            if (_selectedChoices.value.size == 3) {
                disableUnselectedChoices()
            }
        }
    }

    private fun enableAllChoices() {
        _categories.value.forEach { it.isEnabled = true }
    }

    private fun disableUnselectedChoices() {
        _categories.value
            .filterNot { _selectedChoices.value.contains(it) }
            .forEach { it.isEnabled = false }
    }
}

