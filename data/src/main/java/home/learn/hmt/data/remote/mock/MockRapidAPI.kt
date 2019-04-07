package home.learn.hmt.data.remote.mock

import home.learn.hmt.data.model.ArtistEntity
import home.learn.hmt.data.model.LyricEntity
import home.learn.hmt.data.remote.api.RapidAPI
import io.reactivex.Single

class MockRapidAPI constructor() : RapidAPI {
    override fun searchArtist(rating: String, artist: String, page: Int, page_size: Int): Single<List<ArtistEntity>> {
        return Single.just(mutableListOf(artistEntityFake))
    }

    override fun getLyrics(trackID: String): Single<LyricEntity> {
        return Single.just(lyricEntityFake)
    }

}