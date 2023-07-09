package com.redvelvet.presentation.ui.screen.category

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.redvelvet.presentation.R


data class CategoryItem(
    val id: Int,
    @StringRes val label: Int,
    @DrawableRes val icon: Int,
    var isSelected: Boolean = false,
    var isEnabled: Boolean = true
)

class CategoryFactory {
    val categories = listOf(
        CategoryItem(1, R.string.music, R.drawable.ic_music_play, false),
        CategoryItem(2, R.string.sport_and_leisure, R.drawable.ic_volleyball_ball_svgrepo, false),
        CategoryItem(3, R.string.film_and_tv, R.drawable.ic_film_projector_svgrepo, false),
        CategoryItem(4, R.string.arts_and_literature, R.drawable.ic_art, false),
        CategoryItem(5, R.string.history, R.drawable.ic_history, false),
        CategoryItem(6, R.string.society_and_culture, R.drawable.ic_society_and_culture, false),
        CategoryItem(7, R.string.science, R.drawable.ic_applications_science, false),
        CategoryItem(8, R.string.geography, R.drawable.ic_earth_globe_geography_svgrepo, false),
        CategoryItem(9, R.string.food_and_drink, R.drawable.ic_food, false),
        CategoryItem(0, R.string.general_knowledge, R.drawable.ic_head_svgrepo_com_1, false),
    )

    val newCategories = listOf(
        CategoryUIState.CategoryItemUIState(1, "Music", R.drawable.ic_music_play),
        CategoryUIState.CategoryItemUIState(
            2,
            "Sport and Leisure",
            R.drawable.ic_volleyball_ball_svgrepo
        ),
        CategoryUIState.CategoryItemUIState(3, "Film and TV", R.drawable.ic_film_projector_svgrepo),
        CategoryUIState.CategoryItemUIState(4, "Arts and Literature", R.drawable.ic_art),
        CategoryUIState.CategoryItemUIState(5, "History", R.drawable.ic_history),
        CategoryUIState.CategoryItemUIState(
            6,
            "Society and Culture",
            R.drawable.ic_society_and_culture
        ),
        CategoryUIState.CategoryItemUIState(7, "Science", R.drawable.ic_applications_science),
        CategoryUIState.CategoryItemUIState(
            8,
            "Geography",
            R.drawable.ic_earth_globe_geography_svgrepo
        ),
        CategoryUIState.CategoryItemUIState(9, "Food and Drink", R.drawable.ic_food),
        CategoryUIState.CategoryItemUIState(
            0,
            "General Knowledge",
            R.drawable.ic_head_svgrepo_com_1
        ),
    )
}
