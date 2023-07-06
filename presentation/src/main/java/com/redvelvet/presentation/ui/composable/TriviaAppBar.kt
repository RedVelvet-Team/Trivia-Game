package com.redvelvet.presentation.ui.composable

import androidx.compose.foundation.layout.size
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.redvelvet.presentation.R
import com.redvelvet.presentation.ui.theme.Poppins

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TriviaAppBar(
    title: String,
    navigationIconRes: Int = R.drawable.ic_back,
    onNavigationIconClick: () -> Unit = {},
) {
    CenterAlignedTopAppBar(
        title = {
            Text(
                text = title,
                fontSize = 16.sp,
                fontFamily = Poppins,
                fontWeight = FontWeight(600),
                color = Color(0xE5212121),
                textAlign = TextAlign.Center,
            )
        },
        navigationIcon = {
            IconButton(onClick = onNavigationIconClick) {
                Icon(
                    painter = painterResource(navigationIconRes),
                    contentDescription = null,
                    tint = Color(0xE5212121),
                    modifier = Modifier.size(24.dp)
                )
            }
        },
    )
}