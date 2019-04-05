package home.learn.hmt.domain.repository

import home.learn.hmt.domain.model.Artist
import home.learn.hmt.domain.model.Lyric
import home.learn.hmt.domain.repository.base.Repository
import io.reactivex.Single

interface MusicRepository : Repository {
    fun getLyrics(trackID: String): Single<Lyric>

    fun searchArtist(artist: String, page: Int): Single<List<Artist>>
}