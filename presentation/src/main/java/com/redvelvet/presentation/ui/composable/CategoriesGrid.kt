package com.redvelvet.presentation.ui.composable

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.redvelvet.presentation.ui.screen.category.CategoryItem

@Composable
fun CategoriesGrid(
    categories: List<CategoryItem>,
) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        modifier = Modifier
            .fillMaxSize(),
        contentPadding = PaddingValues(bottom = 100.dp),
        content = {
            items(categories.size) { index ->
                val category = categories[index]
                CategoryItem(
                    label = stringResource(category.label),
                    iconResource = category.icon,
                    selected = category.isSelected,
                    enabled = category.isEnabled
                )
            }
        },
    )
}