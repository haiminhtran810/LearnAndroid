package home.learn.hmt.domain.model

import home.learn.hmt.domain.model.base.Model

data class Lyric(
    val lyricsId: String,
    val explicit: Int,
    val lyricsBody: String,
    val scriptTrackingUrl: String,
    val pixelTrackingUrl: String,
    val lyricsCopyright: String,
    val updatedTime: String
) : Model()