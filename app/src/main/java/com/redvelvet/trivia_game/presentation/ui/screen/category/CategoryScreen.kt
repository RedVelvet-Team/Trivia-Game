package com.redvelvet.trivia_game.presentation.ui.screen.category

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.redvelvet.presentation.R
import com.redvelvet.presentation.ui.composable.CategoriesGrid
import com.redvelvet.presentation.ui.composable.CategoryLevelChips
import com.redvelvet.presentation.ui.composable.CategorySelectionInfo
import com.redvelvet.presentation.ui.composable.CustomButton
import com.redvelvet.presentation.ui.composable.TriviaAppBar
import com.redvelvet.presentation.ui.screen.category.utils.SpaceVertical
import com.redvelvet.presentation.ui.screen.category.utils.Utils
import com.redvelvet.presentation.ui.screen.question.SCREEN_KEY_QUESTION_SCREEN
import com.redvelvet.presentation.ui.theme.BackgroundLight


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CategoryScreen(
    navController: NavController,
    viewModel: CategoryScreenViewModel = hiltViewModel()) {

    val state by viewModel.state.collectAsState()

    Scaffold(
        topBar = { TriviaAppBar(title = stringResource(R.string.customize_your_questions)) },
        containerColor = BackgroundLight,
    ) { paddingValues ->
        CategoryScreenContent(
            state,
            paddingValues,
            viewModel::onCategoryItemClicked,
            viewModel::onChipItemClicked,
        ){ chips,categories ->
            navController.navigate("${SCREEN_KEY_QUESTION_SCREEN}/$chips/$categories")
        }
    }
}

@Composable
fun CategoryScreenContent(
    state: CategoryUIState,
    paddingValues: PaddingValues,
    onCategoryItemClicked: (CategoryUIState.CategoryItemUIState) -> Unit,
    onChipItemClicked: (CategoryUIState.ChipItemUIState) -> Unit,
    onStartClick: (String,String) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp)
            .padding(paddingValues)
    ) {
        SpaceVertical(Utils.SPACE_8)
        CategorySelectionInfo()
        SpaceVertical(Utils.SPACE_16)
        CategoryLevelChips(state.chips, onChipItemClicked)
        SpaceVertical(Utils.SPACE_16)
        Box {
            CategoriesGrid(onCategoryItemClicked, categories = state.categories)
            CustomButton(
                label = stringResource(R.string.start),
                onClick = {
                    val selectedChips = state.selectedChips.joinToString(",")
                    val selectedCategories = state.selectedCategories.joinToString(",")
                    onStartClick(selectedChips,selectedCategories)
                },
                modifier = Modifier.align(Alignment.BottomCenter),
                enabled = state.isStartButtonEnabled,
            )
        }
    }
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun CategoryScreenPreview() {
    //CategoryScreen()
}