package home.learn.hmt.data.mapper

import home.learn.hmt.data.remote.mock.lyricEntityFake
import org.junit.Before
import org.junit.Test

class ArtistEntityMapperTest {
    lateinit var lyricEntityMapper: LyricEntityMapper
    @Before
    fun setUp() {
        lyricEntityMapper = LyricEntityMapper()
    }

    @Test
    fun mapToDomain(){
        val entity = lyricEntityFake
        val model = lyricEntityMapper.mapToDomain(entity)
        assert(entity.lyricsId == model.lyricsId)
        assert(entity.lyricsId == model.lyricsId)
        assert(entity.lyricsId == model.lyricsId)
        assert(entity.lyricsId == model.lyricsId)
        assert(entity.lyricsId == model.lyricsId)
        assert(entity.lyricsId == model.lyricsId)
        assert(entity.lyricsId == model.lyricsId)
    }
}