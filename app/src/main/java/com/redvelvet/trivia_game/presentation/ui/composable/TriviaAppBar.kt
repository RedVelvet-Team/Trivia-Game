package com.redvelvet.trivia_game.presentation.ui.composable

import androidx.compose.foundation.layout.size
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.redvelvet.presentation.R
import com.redvelvet.presentation.ui.theme.BackgroundLight
import com.redvelvet.presentation.ui.theme.MainTextLight
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
                fontSize = 18.sp,
                fontFamily = Poppins,
                lineHeight = 24.sp,
                fontWeight = FontWeight(600),
                color = MainTextLight,
                textAlign = TextAlign.Center,
            )
        },
        navigationIcon = {
            IconButton(onClick = onNavigationIconClick) {
                Icon(
                    painter = painterResource(navigationIconRes),
                    contentDescription = null,
                    tint = MainTextLight,
                    modifier = Modifier.size(24.dp)
                )
            }
        },
        colors = TopAppBarDefaults.smallTopAppBarColors(
            containerColor = BackgroundLight,
        ),
    )
}