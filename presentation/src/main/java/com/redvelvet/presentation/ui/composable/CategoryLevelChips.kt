package com.redvelvet.presentation.ui.composable

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.redvelvet.presentation.R

@Composable
fun CategoryLevelChips() {
    val chips = listOf(
        stringResource(R.string.easy),
        stringResource(R.string.medium),
        stringResource(R.string.difficult),
    )

    Row(
        modifier = Modifier.fillMaxWidth(),
    ) {
        chips.forEachIndexed { index, label ->
            Chip(
                label = label,
                onClick = {},
                enabled = index == 0
            )
            Spacer(modifier = Modifier.width(8.dp))
        }
    }
}