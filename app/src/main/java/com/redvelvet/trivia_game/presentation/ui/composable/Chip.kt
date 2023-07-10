package com.redvelvet.trivia_game.presentation.ui.composable

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.SuggestionChip
import androidx.compose.material3.SuggestionChipDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.redvelvet.presentation.ui.theme.OnBackgroundLight
import com.redvelvet.presentation.ui.theme.Poppins
import com.redvelvet.presentation.ui.theme.Primary
import com.redvelvet.presentation.ui.theme.White

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Chip(
    label: String,
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    selected: Boolean,
) {
    SuggestionChip(
        onClick = onClick,
        label = {
            Text(
                text = label,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 10.dp)
                    .padding(end = 8.dp),
                textAlign = TextAlign.Center,
                fontFamily = Poppins,
                fontSize = 14.sp,
            )
        },
        icon = null,
        modifier = modifier,
        elevation = null,
        border = SuggestionChipDefaults.suggestionChipBorder(
            borderWidth = 1.dp,
            borderColor = Primary,
        ),
        enabled = true,
        shape = RoundedCornerShape(16.dp),
        colors = SuggestionChipDefaults.suggestionChipColors(
            labelColor = if (selected) White else Primary,
            containerColor = if (selected) Primary else OnBackgroundLight,
        ),
    )
}