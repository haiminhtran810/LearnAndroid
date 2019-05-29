package home.learn.hmt.data.remote.mock

import home.learn.hmt.data.remote.api.MovieAPI
import home.learn.hmt.data.remote.response.GetMovieListResponse
import io.reactivex.Single

class MockMovieAPI constructor() : MovieAPI {
    override fun getTopRated(page: Int): Single<GetMovieListResponse> {
        return Single.just(null)
    }
}