package home.learn.hmt.data

import home.learn.hmt.data.model.mapper.LyricEntityMapper
import home.learn.hmt.data.remote.api.RapidAPI
import home.learn.hmt.domain.model.Lyric
import home.learn.hmt.domain.repository.MusicRepository
import io.reactivex.Single

class MusicRepositoryImpl constructor(
    private val userApi: RapidAPI,
    private val lyricEntityMapper: LyricEntityMapper
) : MusicRepository {

    override fun getLyrics(trackID: String): Single<Lyric> {
        return userApi.getLyrics(trackID).map { lyricEntityMapper.mapToDomain(it) }
    }
}