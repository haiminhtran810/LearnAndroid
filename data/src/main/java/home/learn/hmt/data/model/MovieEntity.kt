package home.learn.hmt.data.model

import com.google.gson.annotations.SerializedName
import home.learn.hmt.data.model.base.ModelEntity

data class MovieEntity(
    @SerializedName("id")
    val id: String,
    @SerializedName("adult")
    val adult: Boolean = false,
    @SerializedName("backdrop_path")
    val backdropPath: String? = "",
    @SerializedName("budget")
    val budget: Int = 0,
    @SerializedName("homepage")
    val homepage: String = "",
    @SerializedName("imdb_id")
    val imdbId: String = "",
    @SerializedName("original_language")
    val originalLanguage: String = "",
    @SerializedName("original_title")
    val originalTitle: String = "",
    @SerializedName("overview")
    val overview: String = "",
    @SerializedName("popularity")
    val popularity: Double = 0.0,
    @SerializedName("poster_path")
    val posterPath: String? = "",
    @SerializedName("release_date")
    val releaseDate: String = "",
    @SerializedName("revenue")
    val revenue: Int = 0,
    @SerializedName("runtime")
    val runtime: Int = 0,
    @SerializedName("status")
    val status: String = "",
    @SerializedName("tagline")
    val tagline: String = "",
    @SerializedName("title")
    val title: String = "",
    @SerializedName("video")
    val video: Boolean = false,
    @SerializedName("vote_average")
    val voteAverage: Double = 0.0,
    @SerializedName("vote_count")
    val voteCount: Int = 0,
    @SerializedName("isFavorite")
    var isFavorite: Boolean = false
) : ModelEntity()