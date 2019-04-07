package home.learn.hmt.data.remote.api

import home.learn.hmt.data.model.ArtistEntity
import home.learn.hmt.data.model.LyricEntity
import home.learn.hmt.data.remote.response.SearchArtistResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface RapidAPI {
    @GET("/wsr/1.1/track.lyrics.get")
    fun getLyrics(@Query("track_id") trackID: String): Single<LyricEntity>

    @GET("/wsr/1.1/artist.search")
    fun searchArtist(
        @Query("s_artist_rating") rating: String,
        @Query("q_artist") artist: String,
        @Query("page") page: Int,
        @Query("page_size") page_size: Int
    ): Single<List<ArtistEntity>>
}