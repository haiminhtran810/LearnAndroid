package home.learn.hmt.data.model.mapper

import home.learn.hmt.data.model.LyricEntity
import home.learn.hmt.data.model.base.EntityMapper
import home.learn.hmt.domain.model.Lyric

class LyricEntityMapper constructor() : EntityMapper<Lyric, LyricEntity>() {
    override fun mapToDomain(entity: LyricEntity) =
        Lyric(
            entity.lyricsId,
            entity.explicit,
            entity.lyricsBody,
            entity.scriptTrackingUrl,
            entity.pixelTrackingUrl,
            entity.lyricsCopyright,
            entity.updatedTime
        )

    override fun mapTOEntity(model: Lyric) =
        LyricEntity(
            model.lyricsId,
            model.explicit,
            model.lyricsBody,
            model.scriptTrackingUrl,
            model.pixelTrackingUrl,
            model.lyricsCopyright,
            model.updatedTime
        )
}