package home.learn.hmt.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import home.learn.hmt.data.model.base.ModelEntity

data class LyricEntity(
    @Expose
    @SerializedName("lyrics_id")
    val lyricsId: String,
    @Expose
    @SerializedName("explicit")
    val explicit: Int,
    @Expose
    @SerializedName("lyrics_body")
    val lyricsBody: String,
    @Expose
    @SerializedName("script_tracking_url")
    val scriptTrackingUrl: String,
    @Expose
    @SerializedName("pixel_tracking_url")
    val pixelTrackingUrl: String,
    @Expose
    @SerializedName("lyrics_copyright")
    val lyricsCopyright: String,
    @Expose
    @SerializedName("updated_time")
    val updatedTime: String
) : ModelEntity()