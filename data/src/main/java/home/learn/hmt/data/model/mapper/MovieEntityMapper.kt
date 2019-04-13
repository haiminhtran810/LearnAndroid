package home.learn.hmt.data.model.mapper

import home.learn.hmt.data.model.MovieEntity
import home.learn.hmt.data.model.base.EntityMapper
import home.learn.hmt.domain.model.Movie

class MovieEntityMapper : EntityMapper<Movie, MovieEntity>() {
    override fun mapToDomain(entity: MovieEntity) = Movie(
        entity.id,
        entity.adult,
        entity.backdropPath,
        entity.budget,
        entity.homepage,
        entity.imdbId,
        entity.originalLanguage,
        entity.originalTitle,
        entity.overview,
        entity.popularity,
        entity.posterPath,
        entity.releaseDate,
        entity.revenue,
        entity.runtime,
        entity.status,
        entity.tagline,
        entity.title,
        entity.video,
        entity.voteAverage,
        entity.voteCount,
        entity.isFavorite
    )

    override fun mapTOEntity(model: Movie)= MovieEntity(
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
}