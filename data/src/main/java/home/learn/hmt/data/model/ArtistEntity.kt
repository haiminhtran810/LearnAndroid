package home.learn.hmt.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import home.learn.hmt.data.model.base.ModelEntity

data class ArtistEntity(
    @Expose
    @SerializedName("artist_id")
    val artistId: Int,
    @Expose
    @SerializedName("artist_name")
    val artistName: String,
   /* @Expose
    @SerializedName("artist_name_translation")
    val artistNameTranslation: List<String>,*/
    @Expose
    @SerializedName("artist_comment")
    val artistComment: String,
    @Expose
    @SerializedName("artist_country")
    val artistCountry: String,
    @Expose
    @SerializedName("artist_alias")
    val artistAlias: List<String>,
    @Expose
    @SerializedName("artist_rating")
    val artistRating: Int,
    @Expose
    @SerializedName("artist_twitter_url")
    val artistTwitterUrl: String,
    @Expose
    @SerializedName("restricted")
    val restricted: Boolean,
    @Expose
    @SerializedName("updated_time")
    val updatedTime: String
) : ModelEntity()