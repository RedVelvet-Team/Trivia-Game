package com.redvelvet.presentation.ui.composable

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.redvelvet.presentation.R
import com.redvelvet.presentation.ui.screen.category.CategoryUIState
import com.redvelvet.presentation.ui.spacer.SpacerVertical8
import com.redvelvet.presentation.ui.theme.Poppins


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OneCategoryItem(
    item: CategoryUIState.CategoryItemUIState,
    onItemClicked: (CategoryUIState.CategoryItemUIState) -> Unit,
) {
    Card(
        onClick = { onItemClicked(item) },
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight(),
        enabled = item.enabled,
        shape = RoundedCornerShape(16.dp),
        border = if (item.isSelected && item.enabled) BorderStroke(
            2.dp,
            Color(0xFF5C3570)
        ) else null,
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFFF1F1F1),
            disabledContainerColor = Color(0xFFF1F1F1),
        ),
    ) {
        Column(
            modifier = Modifier.padding(vertical = 25.dp, horizontal = 21.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Icon(
                painter = painterResource(item.icon),
                contentDescription = null,
                tint = if (item.enabled) Color(0xFF5C3570) else Color(0x5C7B5C8B),
                modifier = Modifier.size(48.dp),
            )
            SpacerVertical8()
            Text(
                text = item.name,
                modifier = Modifier.fillMaxWidth(),
                fontSize = 14.sp,
                fontFamily = Poppins,
                fontWeight = FontWeight.Medium,
                color = if (item.enabled) Color(0xE6212121) else Color(0x5C212121),
                textAlign = TextAlign.Center,
                maxLines = 1
            )
        }
    }
}

@Preview
@Composable
fun CategoryItemPreview() {
    OneCategoryItem(
        item = CategoryUIState.CategoryItemUIState(
            id = 1,
            name = stringResource(id = R.string.arts_and_literature),
            icon = R.drawable.ic_film_projector_svgrepo,
            isSelected = false,
            enabled = true
        )
    ) {}
}