package home.learn.hmt.learnandroid.model

import home.learn.hmt.learnandroid.model.base.ModelItem


data class LyricItem(
    val lyricsId: String,
    val explicit: Int,
    val lyricsBody: String,
    val scriptTrackingUrl: String,
    val pixelTrackingUrl: String,
    val lyricsCopyright: String,
    val updatedTime: String
) : ModelItem()