package com.redvelvet.trivia_game.presentation.ui.composable

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.redvelvet.presentation.R
import com.redvelvet.presentation.ui.theme.OnBackgroundLight
import com.redvelvet.presentation.ui.theme.Poppins
import com.redvelvet.presentation.ui.theme.SecondaryTextLight

@Composable
fun CategorySelectionInfo() {
    Box(
        modifier = Modifier
            .clip(RoundedCornerShape(16.dp))
            .fillMaxWidth()
            .background(OnBackgroundLight)
            .padding(16.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                painter = painterResource(R.drawable.ic_info_circle_icon),
                contentDescription = null,
                modifier = Modifier
                    .size(16.dp)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = stringResource(R.string.category_max_selection),
                fontSize = 10.sp,
                fontFamily = Poppins,
                fontWeight = FontWeight(400),
                color = SecondaryTextLight,
                maxLines = 3,
                lineHeight = 15.sp,
            )
        }
    }
}

@Preview
@Composable
fun CategorySelectionInfoPreview() {
    CategorySelectionInfo()
}
