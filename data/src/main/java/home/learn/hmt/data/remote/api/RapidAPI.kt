package home.learn.hmt.data.remote.api

import home.learn.hmt.data.model.LyricEntity
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface RapidAPI {
    @GET("/wsr/1.1/track.lyrics.get")
    fun getLyrics(@Query("track_id") trackID: String): Single<LyricEntity>
}