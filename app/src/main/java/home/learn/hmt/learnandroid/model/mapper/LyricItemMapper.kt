package home.learn.hmt.learnandroid.model.mapper

import home.learn.hmt.domain.model.Lyric
import home.learn.hmt.learnandroid.model.LyricItem
import home.learn.hmt.learnandroid.model.base.ItemMapper

class LyricItemMapper : ItemMapper<Lyric, LyricItem> {
    override fun mapToPresentation(model: Lyric) = LyricItem(
        model.lyricsId,
        model.explicit,
        model.lyricsBody,
        model.scriptTrackingUrl,
        model.pixelTrackingUrl,
        model.lyricsCopyright,
        model.updatedTime
    )

    override fun mapToDomain(modelItem: LyricItem) = Lyric(
        modelItem.lyricsId,
        modelItem.explicit,
        modelItem.lyricsBody,
        modelItem.scriptTrackingUrl,
        modelItem.pixelTrackingUrl,
        modelItem.lyricsCopyright,
        modelItem.updatedTime
    )
}