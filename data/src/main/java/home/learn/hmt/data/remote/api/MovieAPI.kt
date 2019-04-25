package home.learn.hmt.data.remote.api

import home.learn.hmt.data.remote.response.GetMovieListResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieAPI {
    @GET("movie/top_rated")
    fun getTopRated(@Query(ApiParams.PAGE) page: Int): Single<GetMovieListResponse>
}

object ApiParams {
    const val PAGE = "page"
    const val SORT_BY = "sort_by"
    const val POPULARITY_DESC = "popularity.desc"
    const val VOTE_AVERAGE_DESC = "vote_average.desc"
}