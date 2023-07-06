package com.redvelvet.presentation.ui.composable

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.SuggestionChip
import androidx.compose.material3.SuggestionChipDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.redvelvet.presentation.ui.theme.Poppins

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Chip(
    label: String,
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    enabled: Boolean = false,
) {
    SuggestionChip(
        onClick = onClick,
        label = {
            Text(
                text = label,
                fontFamily = Poppins,
                textAlign = TextAlign.Center,
                fontSize = 14.sp,
                modifier = modifier.padding(vertical = 10.dp)
            )
        },
        elevation = null,
        border = SuggestionChipDefaults.suggestionChipBorder(
            borderWidth = 1.dp,
            borderColor = Color(0xFF7B5C8B),
            disabledBorderColor = Color(0xFF7B5C8B),
        ),
        enabled = enabled,
        shape = RoundedCornerShape(16.dp),
        colors = SuggestionChipDefaults.suggestionChipColors(
            labelColor = Color(0xFFFFFFFF),
            containerColor = Color(0xFF7B5C8B),
            disabledLabelColor = Color(0xFF7B5C8B),
            disabledContainerColor = Color(0xFFF1F1F1)
        ),
    )
}