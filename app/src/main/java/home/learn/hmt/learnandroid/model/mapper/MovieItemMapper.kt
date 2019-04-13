package home.learn.hmt.learnandroid.model.mapper

import home.learn.hmt.domain.model.Movie
import home.learn.hmt.learnandroid.model.MovieItem
import home.learn.hmt.learnandroid.model.base.ItemMapper

class MovieItemMapper : ItemMapper<Movie, MovieItem>() {
    override fun mapToPresentation(model: Movie) = MovieItem(
        model.id,
        model.adult,
        model.backdropPath,
        model.budget,
        model.homepage,
        model.imdbId,
        model.originalLanguage,
        model.originalTitle,
        model.overview,
        model.popularity,
        model.posterPath,
        model.releaseDate,
        model.revenue,
        model.runtime,
        model.status,
        model.tagline,
        model.title,
        model.video,
        model.voteAverage,
        model.voteCount,
        model.isFavorite
    )

    override fun mapToDomain(modelItem: MovieItem) = Movie(
        modelItem.id,
        modelItem.adult,
        modelItem.backdropPath,
        modelItem.budget,
        modelItem.homepage,
        modelItem.imdbId,
        modelItem.originalLanguage,
        modelItem.originalTitle,
        modelItem.overview,
        modelItem.popularity,
        modelItem.posterPath,
        modelItem.releaseDate,
        modelItem.revenue,
        modelItem.runtime,
        modelItem.status,
        modelItem.tagline,
        modelItem.title,
        modelItem.video,
        modelItem.voteAverage,
        modelItem.voteCount,
        modelItem.isFavorite
    )
}