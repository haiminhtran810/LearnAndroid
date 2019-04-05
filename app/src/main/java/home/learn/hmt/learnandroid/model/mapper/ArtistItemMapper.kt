package home.learn.hmt.learnandroid.model.mapper

import home.learn.hmt.domain.model.Artist
import home.learn.hmt.learnandroid.model.ArtistItem
import home.learn.hmt.learnandroid.model.base.ItemMapper

class ArtistItemMapper constructor() : ItemMapper<Artist, ArtistItem>() {
    override fun mapToPresentation(model: Artist) = ArtistItem(
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

    override fun mapToDomain(modelItem: ArtistItem) = Artist(
        modelItem.artistId,
        modelItem.artistName,
        modelItem.artistNameTranslation,
        modelItem.artistComment,
        modelItem.artistCountry,
        modelItem.artistAlias,
        modelItem.artistRating,
        modelItem.artistTwitterUrl,
        modelItem.restricted,
        modelItem.updatedTime
    )
}