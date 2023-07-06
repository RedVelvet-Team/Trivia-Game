package com.redvelvet.presentation.ui.screen.category

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel


@Composable
fun ComposeScreen(viewModel: CategoryScreenViewModel = hiltViewModel()) {
    LazyVerticalGrid(
        modifier = Modifier.background(Color.DarkGray),
        columns = GridCells.Adaptive(minSize = 128.dp),
        contentPadding = PaddingValues(16.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(viewModel.categories.value) { categoryItem ->
            ChoiceItem(
                choice = categoryItem,
                onSelectionChanged = { choice ->
                    viewModel.toggleChoiceSelection(choice)
                }
            )
        }
    }
}

@Composable
fun ChoiceItem(
    choice: CategoryItem,
    onSelectionChanged: (CategoryItem) -> Unit,
) {
    Card(
        modifier = Modifier
            .padding(16.dp)
            .clickable { onSelectionChanged(choice) },
        colors = CardDefaults.cardColors(
            containerColor = if (choice.isSelected) Color.White else Color.LightGray
        )
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.padding(vertical = 8.dp)
        ) {
            Image(
                painter = painterResource(id = choice.icon),
                contentDescription = stringResource(id = choice.label),
                modifier = Modifier,
                alignment = Alignment.Center
            )
            Text(text = stringResource(id = choice.label), textAlign = TextAlign.Center)
        }
    }
}








@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewComposeScreen() {
    ComposeScreen()
}
