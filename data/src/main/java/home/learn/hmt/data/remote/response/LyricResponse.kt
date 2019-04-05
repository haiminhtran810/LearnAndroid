package home.learn.hmt.data.remote.response

import com.google.gson.annotations.Expose
import home.learn.hmt.domain.model.Lyric

class LyricResponse(
    @Expose
    val lyric: Lyric
)