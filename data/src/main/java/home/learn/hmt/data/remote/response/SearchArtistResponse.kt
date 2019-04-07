package home.learn.hmt.data.remote.response

import com.google.gson.annotations.Expose
import home.learn.hmt.data.model.ArtistEntity

data class SearchArtistResponse(
    val artists: List<ArtistEntity>
)