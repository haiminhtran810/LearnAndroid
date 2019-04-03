package home.learn.hmt.data.remote.mock

import home.learn.hmt.data.model.LyricEntity
import home.learn.hmt.data.remote.api.RapidAPI
import io.reactivex.Single

class MockRapidAPI constructor(): RapidAPI{
    override fun getLyrics(trackID: String): Single<LyricEntity> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}