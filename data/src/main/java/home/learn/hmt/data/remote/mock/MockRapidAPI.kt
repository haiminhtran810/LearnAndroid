package home.learn.hmt.data.remote.mock

import home.learn.hmt.data.model.LyricEntity
import home.learn.hmt.data.remote.api.RapidAPI
import home.learn.hmt.data.remote.response.SearchArtistResponse
import io.reactivex.Single

class MockRapidAPI constructor(): RapidAPI{
    override fun searchArtist(artist: String, rating: String, page: Int, page_size: Int): Single<SearchArtistResponse> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getLyrics(trackID: String): Single<LyricEntity> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}