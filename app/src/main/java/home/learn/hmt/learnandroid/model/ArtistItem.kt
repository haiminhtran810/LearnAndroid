package home.learn.hmt.learnandroid.model

import home.learn.hmt.learnandroid.model.base.ModelItem

data class ArtistItem(
    val artistId: Int,
    val artistName: String,
    val artistComment: String,
    val artistCountry: String,
    val artistAlias: List<String>,
    val artistRating: Int,
    val artistTwitterUrl: String,
    val restricted: Boolean,
    val updatedTime: String
) : ModelItem()