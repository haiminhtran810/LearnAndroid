package home.learn.hmt.data.model

val lyricEntityFake =
    LyricEntity(
        "123", 123, "lyrics_body",
        "script_tracking_url", "pixel_tracking_url",
        "lyrics_copyright", "updated_time"
    )

val artistEntityFake = ArtistEntity(
    1,
    "artist_name",
    "A",
    "artist_comment",
    mutableListOf("A"),
    1,
    "artist_twitter_url",
    true,
    "updated_time"
)
val searchArtistResponseFake = SearchArtistResponse(mutableListOf(artistEntityFake))