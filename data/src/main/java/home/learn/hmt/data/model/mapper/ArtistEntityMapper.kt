package home.learn.hmt.data.model.mapper

import home.learn.hmt.data.model.ArtistEntity
import home.learn.hmt.data.model.base.EntityMapper
import home.learn.hmt.domain.model.Artist

class ArtistEntityMapper constructor() : EntityMapper<Artist, ArtistEntity>() {
    override fun mapToDomain(entity: ArtistEntity) = Artist(
        entity.artistId,
        entity.artistName,
        entity.artistNameTranslation,
        entity.artistComment,
        entity.artistCountry,
        entity.artistAlias,
        entity.artistRating,
        entity.artistTwitterUrl,
        entity.restricted,
        entity.updatedTime
    )

    override fun mapTOEntity(model: Artist) = ArtistEntity(
        model.artistId,
        model.artistName,
        model.artistNameTranslation,
        model.artistComment,
        model.artistCountry,
        model.artistAlias,
        model.artistRating,
        model.artistTwitterUrl,
        model.restricted,
        model.updatedTime
    )
}