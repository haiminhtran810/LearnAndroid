package home.learn.hmt.data.remote.mock

import home.learn.hmt.data.model.LyricEntity
import home.learn.hmt.data.remote.api.RapidAPI
import home.learn.hmt.data.remote.response.SearchArtistResponse
import io.reactivex.Single

class MockRapidAPI constructor() : RapidAPI {
    override fun searchArtist(artist: String, rating: String, page: Int, page_size: Int): Single<SearchArtistResponse> {
        return Single.just(searchArtistResponseFake)
    }

    override fun getLyrics(trackID: String): Single<LyricEntity> {
        return Single.just(lyricEntityFake)
    }

}