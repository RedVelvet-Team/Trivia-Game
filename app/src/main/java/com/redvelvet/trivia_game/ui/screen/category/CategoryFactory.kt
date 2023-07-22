package com.redvelvet.trivia_game.ui.screen.category

import com.redvelvet.trivia_game.R


class CategoryFactory {
    val newCategories = listOf(
        CategoryUIState.CategoryItemUIState(
            1,
            "Music",
            R.drawable.ic_music_play
        ),
        CategoryUIState.CategoryItemUIState(
            2,
            "Sport and Leisure",
            R.drawable.ic_volleyball_ball_svgrepo
        ),
        CategoryUIState.CategoryItemUIState(
            3,
            "Film and TV",
            R.drawable.ic_film_projector_svgrepo
        ),
        CategoryUIState.CategoryItemUIState(
            4, "Arts and Literature", R.drawable.ic_art
        ),
        CategoryUIState.CategoryItemUIState(
            5, "History", R.drawable.ic_history
        ),
        CategoryUIState.CategoryItemUIState(
            6,
            "Society and Culture",
            R.drawable.ic_society_and_culture
        ),
        CategoryUIState.CategoryItemUIState(
            7, "Science", R.drawable.ic_applications_science
        ),
        CategoryUIState.CategoryItemUIState(
            8,
            "Geography",
            R.drawable.ic_earth_globe_geography_svgrepo
        ),
        CategoryUIState.CategoryItemUIState(
            9, "Food and Drink", R.drawable.ic_food
        ),
        CategoryUIState.CategoryItemUIState(
            10,
            "General Knowledge",
            R.drawable.ic_head_svgrepo_com_1
        ),
    )

    val newChips = listOf(
        CategoryUIState.ChipItemUIState(1, "easy"),
        CategoryUIState.ChipItemUIState(2, "medium"),
        CategoryUIState.ChipItemUIState(3, "hard")
    )
}
