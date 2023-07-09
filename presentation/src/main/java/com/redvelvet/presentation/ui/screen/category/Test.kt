package com.redvelvet.presentation.ui.screen.category

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
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
import androidx.hilt.navigation.compose.hiltViewModel
import com.redvelvet.presentation.R
import com.redvelvet.presentation.ui.composable.CategoryLevelChips
import com.redvelvet.presentation.ui.composable.CategorySelectionInfo
import com.redvelvet.presentation.ui.composable.CustomButton
import com.redvelvet.presentation.ui.composable.TriviaAppBar
import com.redvelvet.presentation.ui.spacer.SpacerVertical16
import com.redvelvet.presentation.ui.spacer.SpacerVertical8
import com.redvelvet.presentation.ui.theme.Poppins


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TestCategoryScreen(viewModel: CategoryScreenViewModel = hiltViewModel()) {
    val list = viewModel.categories.collectAsState().value
    Scaffold(
        topBar = { TriviaAppBar(title = stringResource(R.string.customize_your_questions)) },
    ) { paddingValues ->
        TestCategoryScreenContent(list,paddingValues,
            viewModel::toggleChoiceSelection)
    }
}

@Composable
fun TestCategoryScreenContent(
    list: List<CategoryItem>,
    paddingValues: PaddingValues,
    selectItem: (CategoryItem) -> Unit,
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp)
            .padding(paddingValues)
    ) {
        SpacerVertical8()
        CategorySelectionInfo()
        SpacerVertical16()
        CategoryLevelChips()
        SpacerVertical16()
        Box {
            TestCategoriesGrid(selectItem,categories = list)
            CustomButton(
                label = stringResource(R.string.start),
                onClick = { },
                modifier = Modifier.align(Alignment.BottomCenter)
            )
        }
    }
}
@Composable
fun TestCategoriesGrid(selectItem:(CategoryItem) -> Unit,
                   categories: List<CategoryItem>,
) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        modifier = Modifier
            .fillMaxSize(),
        contentPadding = PaddingValues(bottom = 100.dp),
        content = {
            items(categories.size) { index ->
                val category = categories[index]
                TestOneCategoryItem(item = category, select = selectItem)
            }
        },
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TestOneCategoryItem(
    item: CategoryItem,
    select:(CategoryItem) -> Unit,
) {
    Card(
        onClick = {select.invoke(item)},
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight(),
        enabled = item.isEnabled,
        shape = RoundedCornerShape(16.dp),
        border = if (item.isSelected) BorderStroke(2.dp, Color(0xFF5C3570)) else null,
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
                tint = if (item.isEnabled) Color(0xFF2A7BFF) else Color(0xFF5C4C64),
                modifier = Modifier.size(48.dp),
            )
            SpacerVertical8()
            Text(
                text = stringResource(id = item.label),
                modifier = Modifier.fillMaxWidth(),
                fontSize = 14.sp,
                fontFamily = Poppins,
                fontWeight = FontWeight.Medium,
                color = if (item.isEnabled) Color(0x99121212) else Color(0xE5212121),
                textAlign = TextAlign.Center,
                maxLines = 1
            )
        }
    }
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun TestCategoryScreenPreview() {
    TestCategoryScreen()
}

///*/
