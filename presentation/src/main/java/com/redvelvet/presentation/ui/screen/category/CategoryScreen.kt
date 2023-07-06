package com.redvelvet.presentation.ui.screen.category

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.redvelvet.presentation.R
import com.redvelvet.presentation.ui.composable.CategoriesGrid
import com.redvelvet.presentation.ui.composable.CategoryLevelChips
import com.redvelvet.presentation.ui.composable.CategorySelectionInfo
import com.redvelvet.presentation.ui.composable.CustomButton
import com.redvelvet.presentation.ui.composable.TriviaAppBar
import com.redvelvet.presentation.ui.spacer.SpacerVertical16
import com.redvelvet.presentation.ui.spacer.SpacerVertical24


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CategoryScreen() {
    Scaffold(
        topBar = { TriviaAppBar(title = stringResource(R.string.customize_your_questions)) },
    ) { paddingValues ->
        CategoryScreenContent(paddingValues)
    }
}

@Composable
fun CategoryScreenContent(
    paddingValues: PaddingValues,
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp)
            .padding(paddingValues)
    ) {
        SpacerVertical24()
        CategorySelectionInfo()
        SpacerVertical16()
        CategoryLevelChips()
        SpacerVertical16()
        Box {
            CategoriesGrid(categories = emptyList())
            CustomButton(
                label = stringResource(R.string.start),
                onClick = { },
                modifier = Modifier.align(Alignment.BottomCenter)
            )
        }
    }
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun CategoryScreenPreview() {
    CategoryScreen()
}