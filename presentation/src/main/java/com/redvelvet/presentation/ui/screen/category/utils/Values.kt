package com.redvelvet.presentation.ui.screen.category.utils

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

class Utils() {
    companion object {
        val SPACE_1 = 1.dp
        val SPACE_2 = 2.dp
        val SPACE_4 = 4.dp
        val SPACE_8 = 8.dp
        val SPACE_12 = 12.dp
        val SPACE_16 = 16.dp
        val SPACE_24 = 24.dp
        val SPACE_32 = 32.dp
        val SPACE_48 = 48.dp
        val SPACE_64 = 64.dp
    }
}

@Composable
fun SpaceVertical(dp: Dp) {
    Spacer(modifier = Modifier.height(dp))
}

@Composable
fun SpaceHorizontal(dp: Dp) {
    Spacer(modifier = Modifier.width(dp))
}