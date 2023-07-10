package com.redvelvet.trivia_game.presentation.ui.composable

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.redvelvet.presentation.R
import com.redvelvet.presentation.ui.theme.Poppins

@OptIn(ExperimentalMaterial3Api::class)

@Composable
fun QuestionAppBar(header: String) {
    CenterAlignedTopAppBar(
        title = {
            Text(
                modifier = Modifier
                    .clip(RoundedCornerShape(56.dp))
                    .background(color = Color(0xFF7B5C8B))
                    .padding(horizontal = 24.dp, vertical = 8.dp),
                text = header,
                fontSize = 14.sp,
                fontFamily = Poppins,
                fontWeight = FontWeight.Medium,
                color = Color(0xE5F6F6F6),
            )
        },
        navigationIcon = {
            Icon(
                painter = painterResource(id = R.drawable.ic_cancel),
                contentDescription = "error",
                modifier = Modifier
                    .padding(start = 12.dp)
                    .size(24.dp)
            )
        },
    )
}