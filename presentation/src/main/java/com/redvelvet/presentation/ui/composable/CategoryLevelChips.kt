package com.redvelvet.presentation.ui.composable

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.redvelvet.presentation.ui.screen.category.CategoryUIState

@Composable
fun CategoryLevelChips(
    chips: List<CategoryUIState.ChipItemUIState>,
    onClicked: (CategoryUIState.ChipItemUIState) -> Unit,
) {

    Row(
        modifier = Modifier.fillMaxWidth(),
    ) {
        chips.forEachIndexed { index, chip ->
            Chip(
                label = chip.name,
                onClick = { onClicked(chip) },
                modifier = Modifier.weight(1f),
                selected = chip.selected,
            )
            if (index != chips.size - 1) Spacer(modifier = Modifier.width(8.dp))
        }
    }
}