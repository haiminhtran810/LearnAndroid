package home.learn.hmt.domain.model

import home.learn.hmt.domain.model.base.Model

data class Movie(
    val id: String,
    val adult: Boolean = false,
    val backdropPath: String? = "",
    val budget: Int = 0,
    val homepage: String? = "",
    val imdbId: String? = "",
    val originalLanguage: String? = "",
    val originalTitle: String? = "",
    val overview: String ?= "",
    val popularity: Double = 0.0,
    val posterPath: String? = "",
    val releaseDate: String? = "",
    val revenue: Int = 0,
    val runtime: Int = 0,
    val status: String? = "",
    val tagline: String? = "",
    val title: String = "",
    val video: Boolean = false,
    val voteAverage: Double = 0.0,
    val voteCount: Int = 0,
    var isFavorite: Boolean = false
) : Model()