package com.redvelvet.presentation.ui.composable

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.redvelvet.presentation.R

@Composable
fun CategoriesGrid() {
    val categories = mapOf(
        stringResource(R.string.music) to R.drawable.ic_music_play,
        stringResource(R.string.history) to R.drawable.ic_history,
        stringResource(R.string.film_and_tv) to R.drawable.ic_film_projector_svgrepo,
        stringResource(R.string.arts_and_literature) to R.drawable.ic_art,
        stringResource(R.string.food_and_drink) to R.drawable.ic_food,
        stringResource(R.string.science) to R.drawable.ic_applications_science,
        stringResource(R.string.start) to R.drawable.ic_start,
        stringResource(R.string.sport_and_leisure) to R.drawable.ic_food,
        stringResource(R.string.geography) to R.drawable.ic_earth_globe_geography_svgrepo,
        stringResource(R.string.society_and_culture) to R.drawable.ic_society_and_culture,
        stringResource(R.string.general_knowledge) to R.drawable.ic_food,
    )

    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        modifier = Modifier
            .fillMaxSize(),
        contentPadding = PaddingValues(bottom = 100.dp),
        content = {
            items(categories.size) { index ->
                val category = categories.keys.toList()[index]
                val icon = categories.values.toList()[index]
                CategoryItem(label = category, iconResource = icon, selected = index == 3)
            }
        })
}