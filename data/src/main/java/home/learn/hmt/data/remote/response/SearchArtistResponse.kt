package home.learn.hmt.data.remote.response

import com.google.gson.annotations.Expose
import home.learn.hmt.data.model.ArtistEntity

class SearchArtistResponse(
    @Expose
    val artists: List<ArtistEntity>
)