package home.learn.hmt.domain.model

import home.learn.hmt.domain.model.base.Model

data class Artist(
    val artistId: Int,
    val artistName: String,
    val artistNameTranslation: List<String>,
    val artistComment: String,
    val artistCountry: String,
    val artistAlias: List<String>,
    val artistRating: Int,
    val artistTwitterUrl: String,
    val restricted: Boolean,
    val updatedTime: String
) : Model()