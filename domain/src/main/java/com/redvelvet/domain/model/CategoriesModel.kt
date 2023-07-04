package com.redvelvet.domain.model

enum class CategoriesModel {
    Geography, ArtAndLiterature, FoodAndDrink, Science, FilmAndTv, GeneralKnowledge, History, Music, SocietyAndCulture, SportAndLeisure;

    override fun toString(): String {
        return when (this) {
            Geography -> "geography"
            ArtAndLiterature -> "arts_and_literature"
            FoodAndDrink -> "food_and_drink"
            Science -> "science"
            FilmAndTv -> "film_and_tv"
            GeneralKnowledge -> "general_knowledge"
            History -> "history"
            Music -> "music"
            SocietyAndCulture -> "society_and_culture"
            SportAndLeisure -> "sport_and_leisure"
        }
    }
}